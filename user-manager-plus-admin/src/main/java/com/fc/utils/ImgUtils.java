package com.fc.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 保存图片
 *
 * @author: feng.chuang
 * @date: 2020-04-05 17:49
 **/
public class ImgUtils {
    public static String saveImg(String prePath,Object file, String certNumber, HttpServletRequest request) throws IOException {
        if (file instanceof String) {
            return file.toString();
        }
        if (file instanceof MultipartFile) {
            if (((MultipartFile) file).getSize()==0) {
                return prePath+File.separator+"certpic" + File.separator + certNumber + File.separator + "sbxxx.png";
            }
            MultipartFile multipartFile = (MultipartFile) file;
            File saveFile = new File( prePath+File.separator+"certpic" + File.separator + certNumber + File.separator + multipartFile.getOriginalFilename());
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

    public static String virtualPath (String realPath) {
        String substring = realPath.substring(3);
        return substring;
    }
    public static String realPath (String virtualPath) {
        return "D:\\"+virtualPath;

    }

    public static void main(String[] args) {
        String s ="/fc/xxx/yyy/ddd.jpg";
        String substring = s.substring(3);
        System.out.println(substring);
    }
}
