package com.fc.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.codec.binary.Base64;

public class Base64Util {
    /**
     * 图片转化成base64字符串
     *
     * @param imgPath
     * @return
     */
    public static String getImageStr(File imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        String extension = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
        String prefix;
        switch (extension) {//check image's extension
            case "jpeg":
                prefix = "data:image/jpeg;base64,";
                break;
            case "png":
                prefix = "data:image/png;base64,";
                break;
            case "jpg":
                prefix = "data:image/jpg;base64,";
                break;
            default://should write cases for more images types
                prefix = "data:image/jpg;base64,";
                break;
        }
        InputStream in = null;
        byte[] data = null;
        String encode = null; // 返回Base64编码过的字节数组字符串
        // 对字节数组Base64编码
//        BASE64Encoder encoder = new BASE64Encoder();
        try {
            // 读取图片字节数组
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            encode = Base64.encodeBase64String(data);
            encode = prefix + encode;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                in.close();
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return encode;
    }

    /**
     * base64字符串转化成图片
     *
     * @param imgData     图片编码
     * @param imgFilePath 存放到本地路径
     * @return
     * @throws IOException
     */
    @SuppressWarnings("finally")
    public static boolean generateImage(String imgData, String imgFilePath) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
        if (imgData == null) {
            return false;
        }
        String[] strings = imgData.split(",");
        String extension;
        switch (strings[0]) {//check image's extension
            case "data:image/jpeg;base64":
                extension = "jpg";
                break;
            case "data:image/png;base64":
                extension = "png";
                break;
            default://should write cases for more images types
                extension = "jpg";
                break;
        }

        OutputStream out = null;
        try {
            File imgFile = new File(imgFilePath + "." + extension);
            File dir = imgFile.getParentFile();
            if (!dir.exists()) {
                dir.mkdirs();
            }
            out = new FileOutputStream(imgFile);
            // Base64解码
            byte[] b = Base64.decodeBase64(strings[1]);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                    b[i] += 256;
                }
            }
            out.write(b);
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally {
            out.flush();
            out.close();
            return true;
        }
    }
}
