package com.fc.web;

import com.fc.config.WebConfiguration;
import com.fc.mapper.UsersDAO;
import com.fc.model.Users;
import com.fc.model.UsersExample;
import com.fc.param.UserParam;
import com.fc.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
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
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UsersDAO usersDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping("/userList")
    @Cacheable(value = "user_list")
    public Result<List<Users>> list(@RequestParam(value = "cpage", defaultValue = "0") Integer cpage,
                                    @RequestParam(value = "size", defaultValue = "6") Integer pageSize) {
        //page当前页号
        if (cpage == null || cpage == 0) {
            cpage = 1;
        }
        //滑动窗口中格子个数，自行设置
        int navigatePages = 6;

//        int startrow = (cpage - 1) * pageSize;
        //从startrow行开始，查询pageSize条记录
        UsersExample usersExample = new UsersExample();
//        usersExample.setOrderByClause("id limit " + startrow + "," + pageSize);
        List<Users> usersList = usersDAO.selectByExample(usersExample);
        return Result.ofSuccess(usersList);
//        int total = (int) usersDAO.countByExample(new UsersExample());
//        //根据页面属性生成页面对象
//        Page<Users> pageInfo = new Page<>(total, pageSize, navigatePages, cpage, usersList);
//        //传递到前台页面
//        model.addAttribute("page", pageInfo);
//        model.addAttribute("usersList", usersList);
//        return "user/userList";
    }

    @PostMapping("/addUser")
    public Result<?> add(@RequestBody @Valid UserParam userParam, BindingResult result) {
        String errorMsg = "";
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg = errorMsg + error.getCode() + "-" + error.getDefaultMessage() + ";";
            }
            return Result.ofFail(-1, errorMsg);
        }
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUserNameEqualTo(userParam.getUserName());
        List<Users> userList = usersDAO.selectByExample(usersExample);
        Users u = (userList == null || userList.size() == 0) ? null : userList.get(0);
        if (u != null) {
            return Result.ofFail(-2, "用户已存在");
        }
        Users user = new Users();
        BeanUtils.copyProperties(userParam, user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRegisterDate(new Date());
        usersDAO.insert(user);
        return Result.ofSuccess("添加用户成功");
    }

    @PostMapping("/editUser")
    public Result<String> edit(@RequestBody @Valid UserParam userParam, BindingResult result, ModelMap model) {
        String errorMsg = "";
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg = errorMsg + error.getCode() + "-" + error.getDefaultMessage() + ";";
            }
            return Result.ofFail(-1, errorMsg);
        }

        Users user = usersDAO.selectByPrimaryKey(userParam.getId());
        if (user == null) {
            return Result.ofFail(-2, "用户不存在");
        }
        if (!userParam.getUserName().equals(user.getUserName())) {
            UsersExample usersExample = new UsersExample();
            UsersExample.Criteria criteria = usersExample.createCriteria();
            criteria.andUserNameEqualTo(userParam.getUserName());
            List<Users> userList = usersDAO.selectByExample(usersExample);
            Users u = (userList == null || userList.size() == 0) ? null : userList.get(0);
            if (u != null) {
                return Result.ofFail(-3, "用户名已存在");
            }
        }
        String passwordTmp = user.getPassword();
        BeanUtils.copyProperties(userParam, user);
        //如果前端传过来的加密和密码和数据库中的不同，说明管理员要更改该用户密码
        if (!userParam.getPassword().equals(passwordTmp)) {
            user.setPassword(passwordEncoder.encode(userParam.getPassword()));
        }
        usersDAO.updateByPrimaryKeySelective(user);
        return Result.ofSuccess("success");
    }

    @GetMapping("/deleteUser")
    public Result<String> delete(Integer id) {
        usersDAO.deleteByPrimaryKey(id);
        return Result.ofSuccess("success");
    }

    @PostMapping("/changePassword")
    public Result<?> changePassword(@RequestParam String oldPassword, @RequestParam String newPassword, HttpServletRequest request) {
        Integer id = (Integer) request.getSession().getAttribute(WebConfiguration.LOGIN_KEY);
        if (id == null) {
            return Result.ofFail(-1, "用户未登录");
        }
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<Users> userList = usersDAO.selectByExample(usersExample);
        Users user = (userList == null || userList.size() == 0) ? null : userList.get(0);
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            return Result.ofFail(-2, "当前密码错误");
        }
        user.setPassword(passwordEncoder.encode(newPassword));
        usersDAO.updateByPrimaryKey(user);
        request.getSession().removeAttribute(WebConfiguration.LOGIN_KEY);
        request.getSession().removeAttribute(WebConfiguration.LOGIN_USER);
        return Result.ofSuccess("success");
    }
}
