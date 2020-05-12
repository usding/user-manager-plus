package com.fc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author
 *
 */
public class Students implements Serializable {
    /**
     * 用户Id
     */
    private Integer id;

    /**
     * 学员姓名
     */
    private String userName;

    /**
     * 出生日期
     */
    private Date birthDate;

    /**
     * 性别
     */
    private String userSex;

    /**
     * 证件类型
     */
    private String certType;

    /**
     * 证件号码
     */
    private String certNumber;

    /**
     * 民族
     */
    private String celebrities;

    /**
     * 婚姻状况
     */
    private String maritalStatus;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 身份证地址
     */
    private String certAddress;

    /**
     * 户籍所在地
     */
    private String domicile;

    /**
     * 本地房产
     */
    private String localEstate;

    /**
     * 随迁人员
     */
    private String accompanyPerson;

    /**
     * 邮政编码
     */
    private String postalCode;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信
     */
    private String wechat;

    /**
     * 批次
     */
    private Integer batch;

    /**
     * 定金
     */
    private Long deposit;

    /**
     * 尾款
     */
    private Long finalPayment;

    /**
     * 总费用
     */
    private Long totalCost;

    /**
     * 备注
     */
    private String note;

    /**
     * 身份证正面扫描件-图片路径
     */
    private String certFscan;

    /**
     * 身份证反面扫描件-图片路径
     */
    private String certBscan;

    /**
     * 2寸蓝底彩照-图片路径
     */
    private String photoBlue;

    /**
     * 毕业证书扫描件-图片路径
     */
    private String certGscan;

    /**
     * 学员属于哪位工作人员
     */
    private Integer belong;

    /**
     * 更新日期
     */
    private Date updateDate;

    /**
     * 录入日期
     */
    private Date entryDate;

    public String getBelongName() {
        return belongName;
    }

    public void setBelongName(String belongName) {
        this.belongName = belongName;
    }

    private String belongName;

    private static final long serialVersionUID = 1L;

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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertNumber() {
        return certNumber;
    }

    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber;
    }

    public String getCelebrities() {
        return celebrities;
    }

    public void setCelebrities(String celebrities) {
        this.celebrities = celebrities;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCertAddress() {
        return certAddress;
    }

    public void setCertAddress(String certAddress) {
        this.certAddress = certAddress;
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile;
    }

    public String getLocalEstate() {
        return localEstate;
    }

    public void setLocalEstate(String localEstate) {
        this.localEstate = localEstate;
    }

    public String getAccompanyPerson() {
        return accompanyPerson;
    }

    public void setAccompanyPerson(String accompanyPerson) {
        this.accompanyPerson = accompanyPerson;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public Integer getBatch() {
        return batch;
    }

    public void setBatch(Integer batch) {
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCertFscan() {
        return certFscan;
    }

    public void setCertFscan(String certFscan) {
        this.certFscan = certFscan;
    }

    public String getCertBscan() {
        return certBscan;
    }

    public void setCertBscan(String certBscan) {
        this.certBscan = certBscan;
    }

    public String getPhotoBlue() {
        return photoBlue;
    }

    public void setPhotoBlue(String photoBlue) {
        this.photoBlue = photoBlue;
    }

    public String getCertGscan() {
        return certGscan;
    }

    public void setCertGscan(String certGscan) {
        this.certGscan = certGscan;
    }

    public Integer getBelong() {
        return belong;
    }

    public void setBelong(Integer belong) {
        this.belong = belong;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Students students = (Students) o;
        return id.equals(students.id) &&
                userName.equals(students.userName) &&
                birthDate.equals(students.birthDate) &&
                userSex.equals(students.userSex) &&
                certType.equals(students.certType) &&
                certNumber.equals(students.certNumber) &&
                celebrities.equals(students.celebrities) &&
                maritalStatus.equals(students.maritalStatus) &&
                phoneNumber.equals(students.phoneNumber) &&
                certAddress.equals(students.certAddress) &&
                domicile.equals(students.domicile) &&
                localEstate.equals(students.localEstate) &&
                accompanyPerson.equals(students.accompanyPerson) &&
                postalCode.equals(students.postalCode) &&
                email.equals(students.email) &&
                wechat.equals(students.wechat) &&
                batch.equals(students.batch) &&
                deposit.equals(students.deposit) &&
                finalPayment.equals(students.finalPayment) &&
                totalCost.equals(students.totalCost) &&
                note.equals(students.note) &&
                certFscan.equals(students.certFscan) &&
                certBscan.equals(students.certBscan) &&
                photoBlue.equals(students.photoBlue) &&
                certGscan.equals(students.certGscan) &&
                belong.equals(students.belong) &&
                updateDate.equals(students.updateDate) &&
                entryDate.equals(students.entryDate) &&
                belongName.equals(students.belongName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, birthDate, userSex, certType, certNumber, celebrities, maritalStatus, phoneNumber, certAddress, domicile, localEstate, accompanyPerson, postalCode, email, wechat, batch, deposit, finalPayment, totalCost, note, certFscan, certBscan, photoBlue, certGscan, belong, updateDate, entryDate, belongName);
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", birthDate=" + birthDate +
                ", userSex='" + userSex + '\'' +
                ", certType='" + certType + '\'' +
                ", certNumber='" + certNumber + '\'' +
                ", celebrities='" + celebrities + '\'' +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", certAddress='" + certAddress + '\'' +
                ", domicile='" + domicile + '\'' +
                ", localEstate='" + localEstate + '\'' +
                ", accompanyPerson='" + accompanyPerson + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", email='" + email + '\'' +
                ", wechat='" + wechat + '\'' +
                ", batch=" + batch +
                ", deposit=" + deposit +
                ", finalPayment=" + finalPayment +
                ", totalCost=" + totalCost +
                ", note='" + note + '\'' +
                ", certFscan='" + certFscan + '\'' +
                ", certBscan='" + certBscan + '\'' +
                ", photoBlue='" + photoBlue + '\'' +
                ", certGscan='" + certGscan + '\'' +
                ", belong=" + belong +
                ", updateDate=" + updateDate +
                ", entryDate=" + entryDate +
                ", belongName='" + belongName + '\'' +
                '}';
    }
}