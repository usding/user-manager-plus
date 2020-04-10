package fc.model;

import java.io.Serializable;
import java.util.Date;

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
    private String batch;

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
    private String belong;

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

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Students other = (Students) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getBirthDate() == null ? other.getBirthDate() == null : this.getBirthDate().equals(other.getBirthDate()))
            && (this.getUserSex() == null ? other.getUserSex() == null : this.getUserSex().equals(other.getUserSex()))
            && (this.getCertType() == null ? other.getCertType() == null : this.getCertType().equals(other.getCertType()))
            && (this.getCertNumber() == null ? other.getCertNumber() == null : this.getCertNumber().equals(other.getCertNumber()))
            && (this.getCelebrities() == null ? other.getCelebrities() == null : this.getCelebrities().equals(other.getCelebrities()))
            && (this.getMaritalStatus() == null ? other.getMaritalStatus() == null : this.getMaritalStatus().equals(other.getMaritalStatus()))
            && (this.getPhoneNumber() == null ? other.getPhoneNumber() == null : this.getPhoneNumber().equals(other.getPhoneNumber()))
            && (this.getCertAddress() == null ? other.getCertAddress() == null : this.getCertAddress().equals(other.getCertAddress()))
            && (this.getDomicile() == null ? other.getDomicile() == null : this.getDomicile().equals(other.getDomicile()))
            && (this.getLocalEstate() == null ? other.getLocalEstate() == null : this.getLocalEstate().equals(other.getLocalEstate()))
            && (this.getAccompanyPerson() == null ? other.getAccompanyPerson() == null : this.getAccompanyPerson().equals(other.getAccompanyPerson()))
            && (this.getPostalCode() == null ? other.getPostalCode() == null : this.getPostalCode().equals(other.getPostalCode()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getWechat() == null ? other.getWechat() == null : this.getWechat().equals(other.getWechat()))
            && (this.getBatch() == null ? other.getBatch() == null : this.getBatch().equals(other.getBatch()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
            && (this.getFinalPayment() == null ? other.getFinalPayment() == null : this.getFinalPayment().equals(other.getFinalPayment()))
            && (this.getTotalCost() == null ? other.getTotalCost() == null : this.getTotalCost().equals(other.getTotalCost()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getCertFscan() == null ? other.getCertFscan() == null : this.getCertFscan().equals(other.getCertFscan()))
            && (this.getCertBscan() == null ? other.getCertBscan() == null : this.getCertBscan().equals(other.getCertBscan()))
            && (this.getPhotoBlue() == null ? other.getPhotoBlue() == null : this.getPhotoBlue().equals(other.getPhotoBlue()))
            && (this.getCertGscan() == null ? other.getCertGscan() == null : this.getCertGscan().equals(other.getCertGscan()))
            && (this.getBelong() == null ? other.getBelong() == null : this.getBelong().equals(other.getBelong()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getBirthDate() == null) ? 0 : getBirthDate().hashCode());
        result = prime * result + ((getUserSex() == null) ? 0 : getUserSex().hashCode());
        result = prime * result + ((getCertType() == null) ? 0 : getCertType().hashCode());
        result = prime * result + ((getCertNumber() == null) ? 0 : getCertNumber().hashCode());
        result = prime * result + ((getCelebrities() == null) ? 0 : getCelebrities().hashCode());
        result = prime * result + ((getMaritalStatus() == null) ? 0 : getMaritalStatus().hashCode());
        result = prime * result + ((getPhoneNumber() == null) ? 0 : getPhoneNumber().hashCode());
        result = prime * result + ((getCertAddress() == null) ? 0 : getCertAddress().hashCode());
        result = prime * result + ((getDomicile() == null) ? 0 : getDomicile().hashCode());
        result = prime * result + ((getLocalEstate() == null) ? 0 : getLocalEstate().hashCode());
        result = prime * result + ((getAccompanyPerson() == null) ? 0 : getAccompanyPerson().hashCode());
        result = prime * result + ((getPostalCode() == null) ? 0 : getPostalCode().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getWechat() == null) ? 0 : getWechat().hashCode());
        result = prime * result + ((getBatch() == null) ? 0 : getBatch().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
        result = prime * result + ((getFinalPayment() == null) ? 0 : getFinalPayment().hashCode());
        result = prime * result + ((getTotalCost() == null) ? 0 : getTotalCost().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getCertFscan() == null) ? 0 : getCertFscan().hashCode());
        result = prime * result + ((getCertBscan() == null) ? 0 : getCertBscan().hashCode());
        result = prime * result + ((getPhotoBlue() == null) ? 0 : getPhotoBlue().hashCode());
        result = prime * result + ((getCertGscan() == null) ? 0 : getCertGscan().hashCode());
        result = prime * result + ((getBelong() == null) ? 0 : getBelong().hashCode());
        return result;
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
        sb.append(", belong=").append(belong);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}