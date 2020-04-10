package com.fc.mapper;

import com.fc.model.Users;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * test usersDao
 *
 * @author: feng.chuang
 * @date: 2020-03-31 14:26
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersDaoTest {

    @Autowired
    private UsersDAO usersDAO;

    @Test
    public void testUsers() {
        Users users = new Users();
        users.setRole(0);
        users.setUserName("hetong");
        users.setPassword("123");
        users.setPhoneNumber("123456789012");
        users.setRegisterDate(new Date());
        usersDAO.insert(users);
    }
}
