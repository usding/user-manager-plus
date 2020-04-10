package com.fc.model;


import java.io.Serializable;
import java.util.Date;

/**
 * 用户表，公司内部员工基础信息
 *
 * @author 18220
 */
public class User implements Serializable{

    private Integer id;
    private Integer role;
    private String userName;
    private String password;
    private String phoneNumber;
    private Date registerDate;
    private String state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getRegTime() {
        return registerDate;
    }

    public void setRegTime(Date registerDate) {
        this.registerDate = registerDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
