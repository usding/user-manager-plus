package com.fc.utils;

import com.fc.config.WebConfiguration;
import com.fc.model.Students;

import java.io.File;
import java.io.IOException;

/**
 * 保存图片
 *
 * @author: feng.chuang
 * @date: 2020-04-05 17:49
 **/
public class ImgUtils {

    public static void deleteStudentImg(Students student) {
        String dirPath = WebConfiguration.IMAGE_PATH + File.separator + student.getUserName() + "_" + student.getCertNumber();
        File dir = new File(dirPath);
        if (dir.exists() && dir.isDirectory()) {
            deleteDir(dirPath);
        }
    }

    public static void getBase64Img(Students student) {
        if (student.getCertFscan() != null) {

            File f = new File(student.getCertFscan());
            if (f.exists()) {
                student.setCertFscan(Base64Util.getImageStr(f));
            }
        }
        if (student.getCertBscan() != null) {
            File f = new File(student.getCertBscan());
            if (f.exists()) {
                student.setCertBscan(Base64Util.getImageStr(f));
            }
        }
        if (student.getIdPhotoOne() != null) {
            File f = new File(student.getIdPhotoOne());
            if (f.exists()) {
                student.setIdPhotoOne(Base64Util.getImageStr(f));
            }
        }
        if (student.getIdPhotoTwo() != null) {
            File f = new File(student.getIdPhotoTwo());
            if (f.exists()) {
                student.setIdPhotoTwo(Base64Util.getImageStr(f));
            }
        }
        if (student.getIdPhotoThree() != null) {
            File f = new File(student.getIdPhotoThree());
            if (f.exists()) {
                student.setIdPhotoThree(Base64Util.getImageStr(f));
            }
        }
        if (student.getCertGscan() != null) {
            File f = new File(student.getCertGscan());
            if (f.exists()) {
                student.setCertGscan(Base64Util.getImageStr(f));
            }
        }
    }

    public static void saveStudentImages(Students student) throws IOException {
        String userPrefix = student.getUserName() + "_" + student.getCertNumber() + File.separator + student.getUserName() + "_" + student.getCertNumber();
        String idcardFront = student.getCertFscan();
        String idcardBack = student.getCertBscan();
        String contract = student.getCertGscan();
        String portraitOne = student.getIdPhotoOne();
        String portraitTwo = student.getIdPhotoTwo();
        String portraitThree = student.getIdPhotoThree();
        if (idcardFront != null) {
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_idcard_front";
            student.setCertFscan(path + "." + Base64Util.getImageExtension(idcardFront));
            Base64Util.generateImage(idcardFront, path);
        }
        if (idcardBack != null) {
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_idcard_back";
            student.setCertBscan(path + "." + Base64Util.getImageExtension(idcardBack));
            Base64Util.generateImage(idcardBack, path);
        }
        if (portraitOne != null) {
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_portrait_one";
            student.setIdPhotoOne(path + "." + Base64Util.getImageExtension(portraitOne));
            Base64Util.generateImage(portraitOne, path);
        }
        if (portraitTwo != null) {
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_portrait_two";
            student.setIdPhotoOne(path + "." + Base64Util.getImageExtension(portraitTwo));
            Base64Util.generateImage(portraitTwo, path);
        }
        if (portraitThree != null) {
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_portrait_three";
            student.setIdPhotoOne(path + "." + Base64Util.getImageExtension(portraitThree));
            Base64Util.generateImage(portraitThree, path);
        }
        if (contract != null) {
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_contract";
            student.setCertGscan(path + "." + Base64Util.getImageExtension(contract));
            Base64Util.generateImage(contract, path);
        }
    }

    /**
     * 迭代删除文件夹
     *
     * @param dirPath 文件夹路径
     */
    public static void deleteDir(String dirPath) {
        File file = new File(dirPath);
        if (file.isFile()) {
            file.delete();
        }
        else {
            File[] files = file.listFiles();
            if (files == null) {
                file.delete();
            }
            else {
                for (int i = 0; i < files.length; i++) {
                    deleteDir(files[i].getAbsolutePath());
                }
                file.delete();
            }
        }
    }


    public static void main(String[] args) {
        String s = "/fc/xxx/yyy/ddd.jpg";
        String substring = s.substring(3);
        System.out.println(substring);
    }
}
