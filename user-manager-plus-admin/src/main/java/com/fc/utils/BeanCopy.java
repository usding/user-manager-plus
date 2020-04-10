package com.fc.utils;

import com.fc.model.Students;
import com.fc.param.StudentParam;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * bean属性复制，去掉类型不合的bean
 *
 * @author: feng.chuang
 * @date: 2020-04-05 21:00
 **/
public class BeanCopy {
    public static void copy(StudentParam source, Students target) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
          target.setUserName(source.getUserName());
          target.setCertType(source.getCertType());
          target.setCertNumber(source.getCertNumber());
          target.setBirthDate(dateFormat(source.getBirthDate()));
          target.setUserSex(source.getUserSex());
          target.setDeposit(source.getDeposit());
          target.setDomicile(source.getDomicile());
          target.setMaritalStatus(source.getMaritalStatus());
          target.setLocalEstate(source.getLocalEstate());
          target.setAccompanyPerson(source.getAccompanyPerson());
          target.setPhoneNumber(source.getPhoneNumber());
          target.setCertAddress(source.getCertAddress());
          target.setEmail(source.getEmail());
          target.setWechat(source.getWechat());
          target.setBatch(source.getBatch());
          target.setCelebrities(source.getCelebrities());
          target.setFinalPayment(source.getFinalPayment());
          target.setCelebrities(source.getCelebrities());
          target.setTotalCost(source.getTotalCost());
          target.setPostalCode(source.getPostalCode());
          target.setNote(source.getNote());
          target.setCertFscan(source.getCertFscan());
          target.setCertBscan(source.getCertBscan());
          target.setPhotoBlue(source.getPhotoBlue());
          target.setCertGscan(source.getCertGscan());
    }

    public static Date dateFormat(String birthDate){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }


}
