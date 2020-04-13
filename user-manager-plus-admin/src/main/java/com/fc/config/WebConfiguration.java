package com.fc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;
import java.io.File;
import java.io.IOException;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    public static final String LOGIN_KEY = "LOGIN_SESSION_KEY";
    public static final String LOGIN_USER = "LOGIN_SESSION_USER";
    public static final String LOGIN_ROLE = "LOGIN_SESSION_ROLE";

    public static String IMAGE_PATH;

//    @Autowired
//    private FileUploadProp fileUploadProp;


//    @Bean(name = "sessionFilter")
//    public Filter sessionFilter() {
//        return new SessionFilter();
//    }

    //    @Bean
//    public FilterRegistrationBean testFilterRegistration() {
//
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(sessionFilter());
//        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("sessionFilter");
//        registration.setOrder(1);
//        return registration;
//    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry  registry) {
//        registry.addResourceHandler(fileUploadProp.getPath()).addResourceLocations("file:" + fileUploadProp.getDocBase());
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        try {
            registry.addInterceptor(new SessionInterceptor());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Value("${image.path}")
    public void setImagePath(String path) {
        File f = new File(path);
        IMAGE_PATH = f.getAbsolutePath();
    }

}