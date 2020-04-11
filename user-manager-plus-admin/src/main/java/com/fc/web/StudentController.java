package com.fc.web;

import com.fc.config.FileUploadProp;
import com.fc.config.WebConfiguration;
import com.fc.mapper.BatchDAO;
import com.fc.mapper.StudentMapper;
import com.fc.mapper.StudentsDAO;
import com.fc.model.Batch;
import com.fc.model.BatchExample;
import com.fc.model.SimpleStudent;
import com.fc.model.Students;
import com.fc.model.StudentsExample;
import com.fc.model.Users;
import com.fc.param.StudentParam;
import com.fc.result.Page;
import com.fc.result.Result;
import com.fc.utils.BeanCopy;
import com.fc.utils.ImgUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * student controller
 *
 * @author: feng.chuang
 * @date: 2020-04-04 11:30
 **/
@RestController
@RequestMapping("/student")
public class StudentController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private StudentsDAO studentsDAO;

    @Resource
    private BatchDAO batchDAO;

    @Autowired
    private StudentMapper studentMapper;

    /* @Value("${file.upload.path}")
     private String prePath;
 */
    @Autowired
    private FileUploadProp fileUploadProp;

    @GetMapping("/studentList")
    @Cacheable(value = "student_list")
    public Result<?> list(Model model, HttpServletRequest request, @RequestParam(value = "page", defaultValue = "0") Integer cpage,
                          @RequestParam(value = "size", defaultValue = "6") Integer pageSize) {
        //page当前页号
        if (cpage == null || cpage == 0) {
            cpage = 1;
        }
        //滑动窗口中格子个数，自行设置
        int navigatePages = 6;

        //从startrow行开始，查询pageSize条记录
        int startrow = (cpage - 1) * pageSize;
        List<SimpleStudent> studentsList;
        Users users = (Users) request.getSession().getAttribute(WebConfiguration.LOGIN_USER);
        StudentsExample studentsExample = new StudentsExample();
        StudentsExample.Criteria criteria = studentsExample.createCriteria();
        if (users.getRole() == 1) {
            criteria.andBelongEqualTo(users.getId());
            studentsList = studentMapper.selectSimpleStudentByBelong(users.getId(), startrow, pageSize);
        }
        else {
            studentsList = studentMapper.selectSimpleStudent(startrow, pageSize);
        }
        studentsExample.setOrderByClause("id limit " + startrow + "," + pageSize);
//        List<Students> studentsList = studentsDAO.selectByExample(studentsExample);
        int total = (int) studentsDAO.countByExample(new StudentsExample());
        //根据页面属性生成页面对象
        Page<SimpleStudent> pageInfO = new Page<>(total, pageSize, navigatePages, cpage, studentsList);
        //传递到前台页面
//        model.addAttribute("page", pageInfO);
//        model.addAttribute("studentsList", studentsList);
        return Result.ofSuccess(pageInfO);
    }

    @RequestMapping("/toAddStudent")
    public String toAdd(Model model) {
        List<Batch> batchList = batchDAO.selectByExample(new BatchExample());
        model.addAttribute("batchList", batchList);
        return "student/studentAdd";
    }

    @GetMapping("/getStudent")
    public Result<Students> getStudent(@RequestParam Integer id) {
        Students student = studentsDAO.selectByPrimaryKey(id);
        return Result.ofSuccess(student);
    }

    @PostMapping("/addStudent")
    public Result<?> add(@RequestBody @Valid StudentParam studentParam, BindingResult result, HttpServletRequest request) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String errorMsg = "";
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg = errorMsg + error.getCode() + "-" + error.getDefaultMessage() + ";";
            }
            return Result.ofFail(-1, errorMsg);
        }

        StudentsExample studentsExample = new StudentsExample();
        StudentsExample.Criteria criteria = studentsExample.createCriteria();
        criteria.andCertNumberEqualTo(studentParam.getCertNumber());
        List<Students> studentsList = studentsDAO.selectByExample(studentsExample);
        Students stuQueryByDB = (studentsList == null || studentsList.size() == 0) ? null : studentsList.get(0);
        if (stuQueryByDB != null) {
            return Result.ofFail(-2, "用户已存在");
        }
        Students students = new Students();
        BeanCopy.copy(studentParam, students);
        Users users = (Users) request.getSession().getAttribute(WebConfiguration.LOGIN_USER);
        students.setBelong(users.getId());
        studentsDAO.insert(students);
        return Result.ofSuccess("success");
    }

    @RequestMapping("/toEditStudent")
    public String toEdit(Model model, Integer id) {
        Students students = studentsDAO.selectByPrimaryKey(id);
        students.setCertFscan(ImgUtils.virtualPath(students.getCertFscan()));
        students.setCertBscan(ImgUtils.virtualPath(students.getCertBscan()));
        students.setCertGscan(ImgUtils.virtualPath(students.getCertGscan()));
        students.setPhotoBlue(ImgUtils.virtualPath(students.getPhotoBlue()));
        model.addAttribute("studentsInfo", students);
        List<Batch> batchList = batchDAO.selectByExample(new BatchExample());
        model.addAttribute("batchList", batchList);
        return "student/studentEdit";
    }

    @PostMapping(value = "/editStudent", consumes = {"application/json"})
    public Result<?> edit(@RequestBody @Valid StudentParam studentParam, BindingResult result) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String errorMsg = "";
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg = new StringBuilder().append(errorMsg)
                        .append(error.getCode())
                        .append("-")
                        .append(error.getDefaultMessage())
                        .append(";").toString();
            }
            return Result.ofFail(-1, errorMsg);
        }
        Students students = new Students();
        BeanCopy.copy(studentParam, students);
        students.setId(studentParam.getId());
        studentsDAO.updateByPrimaryKeySelective(students);

        return Result.ofSuccess("success");
    }

    @RequestMapping("/deleteStudent")
    public String delete(Integer id) {
        studentsDAO.deleteByPrimaryKey(id);
        return "redirect:/student/studentList";
    }

    @RequestMapping("/queryBatch")
    public String queryBatchList(Model model) {
        List<Batch> batchList = batchDAO.selectByExample(new BatchExample());
        model.addAttribute("batchList", batchList);
        return "batch/batchList";

    }

    @RequestMapping("/studentDetail")
    public String studentDetail(Model model, Integer id) {
        Students students = studentsDAO.selectByPrimaryKey(id);
        students.setCertFscan(ImgUtils.virtualPath(students.getCertFscan()));
        students.setCertBscan(ImgUtils.virtualPath(students.getCertBscan()));
        students.setCertGscan(ImgUtils.virtualPath(students.getCertGscan()));
        students.setPhotoBlue(ImgUtils.virtualPath(students.getPhotoBlue()));
        model.addAttribute("studentsInfo", students);
        List<Batch> batchList = batchDAO.selectByExample(new BatchExample());
        model.addAttribute("batchList", batchList);
        return "student/studentDetail";
    }

    public static void main(String[] args) {
        String reg = "((^(13|15|17|18|19)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
        boolean matches = Pattern.matches(reg, "17568938656");
//        System.out.println(matches);
    }
}
