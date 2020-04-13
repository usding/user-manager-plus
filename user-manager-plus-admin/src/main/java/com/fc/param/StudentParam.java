package com.fc.param;

import com.fc.utils.Validator;
//import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 学员信息后端校验实体类
 *
 * @author: feng.chuang
 * @date: 2020-04-05 16:31
 **/
public class StudentParam {
    private static final long serialVersionUID = 1L;

    /**
     * 用户Id
     */
    private Integer id;

    /**
     * 学员姓名
     */
    @NotEmpty(message = "姓名不能为空")
    private String userName;

    /**
     * 出生日期
     */
    @NotNull(message = "出生日期不能为空")
    private String birthDate;

    /**
     * 性别
     */
    @NotEmpty(message = "性别不能为空")
    private String userSex;

    /**
     * 证件类型
     */
    @NotEmpty(message = "证件类型不能为空")
    private String certType;

    /**
     * 证件号码
     */
    @NotEmpty(message = "证件号码不能为空")
    @Pattern(regexp = "/(^\\d{15}$)|(^\\d{18}$)|(^\\d{17}(\\d|X|x)$)/",message = "证件号码格式不正确")
    private String certNumber;

    /**
     * 民族
     */
    //@NotEmpty(message = "民族不能为空")
    private String celebrities;

    /**
     * 婚姻状况
     */
    //@NotEmpty(message = "婚姻状况不能为空")
    private String maritalStatus;

    /**
     * 手机号
     */
    @NotEmpty(message = "手机号不能为空")
    @Pattern(regexp = Validator.REGEX_MOBILE,message = "手机号格式不正确")
    private String phoneNumber;

    /**
     * 身份证地址
     */
    //@NotEmpty(message = "身份证地址不能为空")
    private String certAddress;

    /**
     * 户籍所在地
     */
    @NotEmpty(message = "户籍地址不能为空")
    private String domicile;

    /**
     * 本地房产
     */
    @NotEmpty(message = "本地房产不能为空")
    private String localEstate;

    /**
     * 随迁人员
     */
    //@NotEmpty(message = "随迁人员不能为空")
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
    //@NotEmpty(message = "批次不能为空")
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
    @NotNull(message = "身份证正面扫描件不能为空")
    private String certFscan;

    /**
     * 身份证反面扫描件-图片路径
     */
    @NotNull(message = "身份证反面扫描件不能为空")
    private String certBscan;

    /**
     * 2寸蓝底彩照-图片路径
     */
    @NotNull(message = "2寸蓝底彩照不能为空")
    private String photoBlue;

    /**
     * 毕业证书扫描件-图片路径
     */
    //@NotNull(message = "毕业证书扫描件不能为空")
    private String certGscan;



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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", birthDate=").append(birthDate);
        sb.append(", userSex=").append(userSex);
        sb.append(", certType=").append(certType);
        sb.append(", certNumber=").append(certNumber);
        sb.append(", celebrities=").append(celebrities);
        sb.append(", maritalStatus=").append(maritalStatus);
        sb.append(", phoneNumber=").append(phoneNumber);
        sb.append(", certAddress=").append(certAddress);
        sb.append(", domicile=").append(domicile);
        sb.append(", localEstate=").append(localEstate);
        sb.append(", accompanyPerson=").append(accompanyPerson);
        sb.append(", postalCode=").append(postalCode);
        sb.append(", email=").append(email);
        sb.append(", wechat=").append(wechat);
        sb.append(", batch=").append(batch);
        sb.append(", deposit=").append(deposit);
        sb.append(", finalPayment=").append(finalPayment);
        sb.append(", totalCost=").append(totalCost);
        sb.append(", note=").append(note);
        sb.append(", certFscan=").append(certFscan);
        sb.append(", certBscan=").append(certBscan);
        sb.append(", photoBlue=").append(photoBlue);
        sb.append(", certGscan=").append(certGscan);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
