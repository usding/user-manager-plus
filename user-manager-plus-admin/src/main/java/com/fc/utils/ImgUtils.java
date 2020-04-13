package com.fc.utils;

import com.fc.config.WebConfiguration;
import com.fc.model.Students;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 保存图片
 *
 * @author: feng.chuang
 * @date: 2020-04-05 17:49
 **/
public class ImgUtils {

    public static String IMAGE_PATH;

    @Value("${image.path}")
    public void setImagePath(String path) {
        IMAGE_PATH = path;
    }

    public static String saveImg(String prePath, Object file, String certNumber, HttpServletRequest request) throws IOException {
        if (file instanceof String) {
            return file.toString();
        }
        if (file instanceof MultipartFile) {
            if (((MultipartFile) file).getSize() == 0) {
                return prePath + File.separator + "certpic" + File.separator + certNumber + File.separator + "sbxxx.png";
            }
            MultipartFile multipartFile = (MultipartFile) file;
            File saveFile = new File(prePath + File.separator + "certpic" + File.separator + certNumber + File.separator + multipartFile.getOriginalFilename());
            if (!saveFile.exists()) {
                if (!saveFile.getParentFile().exists()) {
                    saveFile.getParentFile().mkdirs();
                }
                saveFile.createNewFile();
            }
            multipartFile.transferTo(saveFile);
            return saveFile.getAbsolutePath();
        }
        return null;
    }

   /* public static String virtualPath (String realPath) {
        String[] substring = realPath.split(":");
        return substring[1];
    }*/

    public static String virtualPath(String realPath) {
        String substring = realPath.substring(3);
        return substring;
    }

    public static String realPath(String virtualPath) {
        return "D:\\" + virtualPath;

    }

    public static void deleteExistsImg(File[] images, String prefix) {
        for (File img : images) {
            if (img.getName().startsWith(prefix)) {
                img.delete();
            }
        }
    }

    public static void saveStudentImages(Students student) throws IOException {
        File dir = new File(WebConfiguration.IMAGE_PATH);
        File[] images = new File[0];
        if (dir.isDirectory()) {
            images = dir.listFiles();
        }
        String userPrefix = student.getUserName() + "_" + student.getCertNumber();
        String idcardFront = student.getCertFscan();
        String idcardBack = student.getCertBscan();
        String diploma = student.getCertGscan();
        String portrait = student.getPhotoBlue();
        if (idcardFront != null) {
            deleteExistsImg(images, userPrefix + "_idcard_front");
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_idcard_front";
            Base64Util.generateImage(idcardFront, path);
        }
        if (idcardBack != null) {
            deleteExistsImg(images, userPrefix + "_idcard_back");
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_idcard_back";
            Base64Util.generateImage(idcardBack, path);
        }
        if (portrait != null) {
            deleteExistsImg(images, userPrefix + "_portrait");
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_portrait";
            Base64Util.generateImage(portrait, path);
        }
        if (diploma != null) {
            deleteExistsImg(images, userPrefix + "_diploma");
            String path = WebConfiguration.IMAGE_PATH + File.separator + userPrefix + "_diploma";
            Base64Util.generateImage(diploma, path);
        }
    }

    public static void main(String[] args) {
        String s = "/fc/xxx/yyy/ddd.jpg";
        String substring = s.substring(3);
        System.out.println(substring);
    }
}
