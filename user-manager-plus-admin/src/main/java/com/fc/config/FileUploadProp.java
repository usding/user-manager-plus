package com.fc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件上传虚拟配置
 *
 * @author: feng.chuang
 * @date: 2020-04-06 13:04
 **/
@Component
@ConfigurationProperties(prefix = "file.upload")
public class FileUploadProp {
    private String  docBase;

    private String path;

    public String getDocBase() {
        return docBase;
    }

    public void setDocBase(String docBase) {
        this.docBase = docBase;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }


}
