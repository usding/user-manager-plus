package com.fc;

import java.io.File;

/**
 * 文件保存路径问题
 *
 * @author: feng.chuang
 * @date: 2020-04-06 10:34
 **/
public class FileTest {
    public static void main(String[] args) {
        File file = new File("D:\\images\\12345\\1238.png");
        if (!file.exists()) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
    }
}
