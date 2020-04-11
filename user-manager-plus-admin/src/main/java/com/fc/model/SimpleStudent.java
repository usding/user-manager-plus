package com.fc.model;

import java.io.Serializable;

public class SimpleStudent implements Serializable {
    private Integer id;
    private String userName;
    private String gender;
    private String phoneNumber;
    private String localEstate;
    private String married;
    private String wechat;
    private String batch;
    private Long deposit;
    private Long finalPayment;
    private Long totalCost;

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public Long getFinalPayment() {
        return finalPayment;
    }

    public void setFinalPayment(Long finalPayment) {
        this.finalPayment = finalPayment;
    }

    public Long getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Long totalCost) {
        this.totalCost = totalCost;
    }


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
