package com.fc.web;

import com.fc.config.WebConfiguration;
import com.fc.mapper.BatchDAO;
import com.fc.mapper.StudentMapper;
import com.fc.mapper.StudentsDAO;
import com.fc.mapper.UsersDAO;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
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
    private UsersDAO usersDAO;

    @Resource
    private BatchDAO batchDAO;

    @GetMapping("/studentList")
    @Cacheable(value = "student_list")
    public Result<?> list(@RequestParam(value = "page", defaultValue = "0") Integer cpage,
                          @RequestParam(value = "size", defaultValue = "6") Integer pageSize, HttpServletRequest request) {
        //page当前页号
        if (cpage == null || cpage == 0) {
            cpage = 1;
        }
        //滑动窗口中格子个数，自行设置
        int navigatePages = 6;

        //从startrow行开始，查询pageSize条记录
        int startrow = (cpage - 1) * pageSize;
        List<Students> studentsList;
        Users users = (Users) request.getSession().getAttribute(WebConfiguration.LOGIN_USER);
        StudentsExample studentsExample = new StudentsExample();
        studentsExample.setOrderByClause("id limit " + startrow + "," + pageSize);
        StudentsExample.Criteria criteria = studentsExample.createCriteria();
        if (users.getRole() == 1) {
            criteria.andBelongEqualTo(users.getId());
            studentsList = studentsDAO.selectByExample(studentsExample);
            criteria.andBelongEqualTo(users.getId());
        }
        else {
            studentsList = studentsDAO.selectByExample(studentsExample);
        }

        for (Students student : studentsList) {
            Integer belong = student.getBelong();
            Users belongUser = usersDAO.selectByPrimaryKey(belong);
            if (belongUser != null) {
                student.setBelongName(belongUser.getUserName());
            }
        }
        int total = (int) studentsDAO.countByExample(studentsExample);
        //根据页面属性生成页面对象
        Page<Students> pageInfo = new Page<>(total, pageSize, navigatePages, cpage, studentsList);
        return Result.ofSuccess(pageInfo);
    }

    @RequestMapping("/toAddStudent")
    public String toAdd(Model model) {
        List<Batch> batchList = batchDAO.selectByExample(new BatchExample());
        model.addAttribute("batchList", batchList);
        return "student/studentAdd";
    }

    @GetMapping("/getStudent")
    public Result<Students> getStudent(@RequestParam Integer id, HttpServletRequest request) {
        Users user = (Users) request.getSession().getAttribute(WebConfiguration.LOGIN_USER);
        Students student = studentsDAO.selectByPrimaryKey(id);
        ImgUtils.getBase64Img(student);
        if (user.getRole() == 1) {
            if (!student.getBelong().equals(user.getId())) {
                return Result.ofFail(-1, "该学员不属于当前用户");
            }
        }
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
        students.setUpdateDate(new Date());
        //将学员照片存储下来
        ImgUtils.saveStudentImages(students);
        studentsDAO.insert(students);
        return Result.ofSuccess("success");
    }

    @PostMapping(value = "/editStudent", consumes = {"application/json"})
    public Result<?> edit(@RequestBody @Valid StudentParam studentParam, BindingResult result, HttpServletRequest request) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
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
        Students s = studentsDAO.selectByPrimaryKey(studentParam.getId());
        if (s == null) {
            return Result.ofFail(-2, "学员不存在");
        }
        //将原来的照片删除掉
        ImgUtils.deleteStudentImg(s);
        Users user = (Users) request.getSession().getAttribute(WebConfiguration.LOGIN_USER);
        if (user.getRole() == 1) {
            if (!s.getBelong().equals(user.getId())) {
                return Result.ofFail(-3, "该学员不属于当前用户");
            }
        }
        Students students = new Students();
        BeanCopy.copy(studentParam, students);
        students.setId(studentParam.getId());
        students.setUpdateDate(new Date());
        ImgUtils.saveStudentImages(students);
        studentsDAO.updateByPrimaryKeySelective(students);
        return Result.ofSuccess("success");
    }

    @GetMapping("/deleteStudent")
    public Result<String> delete(Integer id, HttpServletRequest request) {
        Students student = studentsDAO.selectByPrimaryKey(id);
        if (student == null) {
            return Result.ofFail(-1, "该学员不存在");
        }
        Users user = (Users) request.getSession().getAttribute(WebConfiguration.LOGIN_USER);
        if (user.getRole() == 0) {
            studentsDAO.deleteByPrimaryKey(id);
            //删除该用户图片
            ImgUtils.deleteStudentImg(student);
        }
        else {
            if (student.getBelong().equals(user.getId())) {
                studentsDAO.deleteByPrimaryKey(id);
                //删除该用户图片
                ImgUtils.deleteStudentImg(student);
            }
            else {
                return Result.ofFail(-1, "要删除的学员不属于该用户");
            }
        }
        return Result.ofSuccess("success");
    }

    @PostMapping("/searchStudent")
    public Result<?> searchStudent(@RequestBody StudentParam studentParam, BindingResult result, HttpServletRequest request) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        StudentsExample studentsExample = new StudentsExample();
        StudentsExample.Criteria criteria = studentsExample.createCriteria();
        if (studentParam.getUserName() != null) {
            criteria.andUserNameLike(studentParam.getUserName());
        }
        if (studentParam.getBatch() != null) {
            criteria.andBatchEqualTo(studentParam.getBatch());
        }
        Users users = (Users) request.getSession().getAttribute(WebConfiguration.LOGIN_USER);
        if (users.getRole() == 1) {
            criteria.andBelongEqualTo(users.getId());
        }
        List<Students> res = studentsDAO.selectByExample(studentsExample);
        for (Students student : res) {
            Integer belong = student.getBelong();
            Users belongUser = usersDAO.selectByPrimaryKey(belong);
            if (belongUser != null) {
                student.setBelongName(belongUser.getUserName());
            }
        }
        return Result.ofSuccess(res);
    }

    @RequestMapping("/queryBatch")
    public String queryBatchList(Model model) {
        List<Batch> batchList = batchDAO.selectByExample(new BatchExample());
        model.addAttribute("batchList", batchList);
        return "batch/batchList";

    }



    public static void main(String[] args) {
        String reg = "((^(13|15|17|18|19)[0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
        boolean matches = Pattern.matches(reg, "17568938656");
//        System.out.println(matches);
    }
}
