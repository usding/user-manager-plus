package com.fc.model;

import java.io.Serializable;

public class SimpleStudent implements Serializable {
    private Integer id;
    private String userName;
    private String gender;
    private String phoneNumber;
    private String localEstate;
    private String married;

    public String getMarried() {
        return married;
    }

    public void setMarried(String married) {
        this.married = married;
    }



    public String getLocalEstate() {
        return localEstate;
    }

    public void setLocalEstate(String localEstate) {
        this.localEstate = localEstate;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
