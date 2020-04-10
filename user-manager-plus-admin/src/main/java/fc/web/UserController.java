package fc.web;


import com.fc.mapper.UsersDAO;
import com.fc.model.Users;
import com.fc.model.UsersExample;
import com.fc.param.UserParam;
import com.fc.result.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UsersDAO usersDAO;

    @RequestMapping("/userList")
    @Cacheable(value="user_list")
    public String list(Model model,@RequestParam(value = "cpage", defaultValue = "0") Integer cpage,
                       @RequestParam(value = "size", defaultValue = "6") Integer pageSize) {
        //page当前页号
        if (cpage==null ||cpage==0) {
            cpage=1;
        }
        //滑动窗口中格子个数，自行设置
        int navigatePages=6;

        int startrow=(cpage-1)*pageSize;
        //从startrow行开始，查询pageSize条记录
        UsersExample usersExample = new UsersExample();
        usersExample.setOrderByClause("id limit "+startrow+","+pageSize);
        List<Users> usersList=usersDAO.selectByExample(usersExample);
        int total= (int) usersDAO.countByExample(new UsersExample());
        //根据页面属性生成页面对象
        Page<Users> pageInfo =new Page<>(total, pageSize, navigatePages, cpage, usersList);
        //传递到前台页面
        model.addAttribute("page", pageInfo);
        model.addAttribute("usersList", usersList);
        return "user/userList";
    }

    @RequestMapping("/toAddUser")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/addUser")
    public String add(@Valid UserParam userParam,BindingResult result, ModelMap model) {
        String errorMsg="";
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg=errorMsg + error.getCode() + "-" + error.getDefaultMessage() +";";
            }
            model.addAttribute("errorMsg",errorMsg);
            return "user/userAdd";
        }
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUserNameEqualTo(userParam.getUserName());
        List<Users> userList = usersDAO.selectByExample(usersExample);
        Users u = (userList == null||userList.size()==0)?null:userList.get(0);
        if(u!=null){
            model.addAttribute("errorMsg","用户已存在!");
            return "user/userAdd";
        }
        Users user=new Users();
        BeanUtils.copyProperties(userParam,user);
        user.setRegisterDate(new Date());
        usersDAO.insert(user);
        return "redirect:/user/userList";
    }

    @RequestMapping("/toEditUser")
    public String toEdit(Model model,Integer id) {
        Users users=usersDAO.selectByPrimaryKey(id);
        model.addAttribute("users", users);
        return "user/userEdit";
    }

    @RequestMapping("/editUser")
    public String edit(@Valid UserParam userParam, BindingResult result,ModelMap model) {
        String errorMsg="";
        if(result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg=errorMsg + error.getCode() + "-" + error.getDefaultMessage() +";";
            }
            model.addAttribute("errorMsg",errorMsg);
            model.addAttribute("user", userParam);
            return "user/userEdit";
        }

        Users user=usersDAO.selectByPrimaryKey(userParam.getId());
        BeanUtils.copyProperties(userParam,user);
        user.setRegisterDate(new Date());
        usersDAO.updateByPrimaryKeySelective(user);
        return "redirect:/user/userList";
    }

    @RequestMapping("/deleteUser")
    public String delete(Integer id) {
        usersDAO.deleteByPrimaryKey(id);
        return "redirect:/user/userList";
    }
}
