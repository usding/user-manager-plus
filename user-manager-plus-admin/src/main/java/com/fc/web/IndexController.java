package com.fc.web;

import com.fc.config.WebConfiguration;
import com.fc.mapper.UsersDAO;
import com.fc.model.User;
import com.fc.model.Users;
import com.fc.model.UsersExample;
import com.fc.param.LoginParam;
import com.fc.param.RegisterParam;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

/**
 * 登录/注销/注册
 *
 * @author 18220
 * @date 2020-04-04
 */
@RestController
public class IndexController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private UsersDAO usersDAO;


    @Value("${spring.mail.username}")
    private String from;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        Integer id = (Integer) request.getSession().getAttribute(WebConfiguration.LOGIN_KEY);
        if (null == id) {
            return "login";
        }
        else {
            return "redirect:/user/userList";
        }
    }

    @RequestMapping(value = "/toLogin", produces = {"text/html"})
    public String toLogin() throws IOException {
        ClassPathResource resource = new ClassPathResource("public/index.html");
        return IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    @RequestMapping("/login")
    public String login(@Valid LoginParam loginParam, BindingResult result, ModelMap model, HttpServletRequest request) {
        String errorMsg = "";
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg = errorMsg + error.getCode() + "-" + error.getDefaultMessage() + ";";
            }
            model.addAttribute("errorMsg", errorMsg);
            return "login";
        }
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUserNameEqualTo(loginParam.getLoginName());
        List<Users> userList = usersDAO.selectByExample(usersExample);
        Users user = (userList == null || userList.size() == 0) ? null : userList.get(0);
        if (user == null) {
            model.addAttribute("errorMsg", "用户名不存在!");
            return "login";
        }
        else if (!user.getPassword().equals(loginParam.getPassword())) {
            model.addAttribute("errorMsg", "密码错误！");
            return "login";
        }
        request.getSession().setAttribute(WebConfiguration.LOGIN_ROLE, user.getRole());
        if (user.getRole() == 0) {
            request.getSession().setAttribute(WebConfiguration.LOGIN_KEY, user.getId());
            request.getSession().setAttribute(WebConfiguration.LOGIN_USER, user);
            return "index";
        }
        else {
            request.getSession().setAttribute(WebConfiguration.LOGIN_KEY, user.getId());
            request.getSession().setAttribute(WebConfiguration.LOGIN_USER, user);
            return "redirect:/student/studentList";
        }


    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request) {
        request.getSession().removeAttribute(WebConfiguration.LOGIN_KEY);
        request.getSession().removeAttribute(WebConfiguration.LOGIN_USER);
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(@Valid RegisterParam registerParam, BindingResult result, ModelMap model) {
        logger.info("register param" + registerParam.toString());
        String errorMsg = "";
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            for (ObjectError error : list) {
                errorMsg = errorMsg + error.getCode() + "-" + error.getDefaultMessage() + ";";
            }
            model.addAttribute("errorMsg", errorMsg);
            return "register";
        }
        UsersExample usersExample = new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUserNameEqualTo(registerParam.getUserName());
        User u = (User) usersDAO.selectByExample(usersExample);
        if (u != null) {
            model.addAttribute("errorMsg", "用户已存在!");
            return "register";
        }
        Users user = new Users();
        BeanUtils.copyProperties(registerParam, user);
        user.setRegisterDate(new Date());
        ;
        //user.setUserType("manage");
        user.setState("A");
        usersDAO.insert(user);
        //sendRegisterMail(user);
        logger.info("register user " + user.toString());
        return "login";
    }

    /*public void sendRegisterMail(User user) {
        Context context = new Context();
        context.setVariable("id", user.getId());
        String emailContent = templateEngine.process("emailTemplate", context);
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(user.getEmail());
            helper.setSubject("注册验证邮件");
            helper.setText(emailContent, true);
            mailSender.send(message);
        } catch (Exception e) {
            logger.error("发送注册邮件时异常！", e);
        }
    }*/


    @RequestMapping("/verified/{id}")
    public String verified(@PathVariable("id") Integer id, ModelMap model) {
        Users user = usersDAO.selectByPrimaryKey(id);
        if (user != null && "unverified".equals(user.getState())) {
            user.setState("verified");
            usersDAO.insert(user);
            model.put("userName", user.getUserName());
        }
        return "verified";
    }

}
