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
        if (student.getPhotoBlue() != null) {
            File f = new File(student.getPhotoBlue());
            if (f.exists()) {
                student.setPhotoBlue(Base64Util.getImageStr(f));
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
        String diploma = student.getCertGscan();
        String portrait = student.getPhotoBlue();
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
        if (portrait != null) {
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_portrait";
            student.setPhotoBlue(path + "." + Base64Util.getImageExtension(portrait));
            Base64Util.generateImage(portrait, path);
        }
        if (diploma != null) {
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_diploma";
            student.setCertGscan(path + "." + Base64Util.getImageExtension(diploma));
            Base64Util.generateImage(diploma, path);
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
