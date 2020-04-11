package com.fc.utils;

import com.fc.model.BatchExample;
import com.fc.model.Students;
import com.fc.model.StudentsExample;
import com.fc.model.UsersExample;

import java.util.List;

/**
 * @author: feng.chuang
 * @date: 2020-04-11 07:57
 **/
public class ExampleUtils {
    public static UsersExample GetUsersExample() {
        UsersExample example = new UsersExample();
        return example;
    }

    public static StudentsExample getStudentsExample() {
        StudentsExample example = new StudentsExample();
        return example;
    }

    public static BatchExample getBatchExample() {
        BatchExample example = new BatchExample();
        return example;
    }

    public static void main(String[] args) {
        UsersExample usersExample = GetUsersExample();
        System.out.println(usersExample);
        List<UsersExample.Criteria> oredCriteria = usersExample.getOredCriteria();
        System.out.println(oredCriteria);
        System.out.println(oredCriteria.get(0));
        System.out.println(usersExample.createCriteria());

    }
}
