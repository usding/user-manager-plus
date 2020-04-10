package com.fc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.Filter;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    public static final String LOGIN_KEY="LOGIN_SESSION_KEY";
    public static final String LOGIN_USER="LOGIN_SESSION_USER";
    public static final String LOGIN_ROLE="LOGIN_SESSION_ROLE";

    @Autowired
    private FileUploadProp fileUploadProp;


    @Bean(name = "sessionFilter")
    public Filter sessionFilter() {
        return new SessionFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {

        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(sessionFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("sessionFilter");
        registration.setOrder(1);
        return registration;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry  registry) {
        registry.addResourceHandler(fileUploadProp.getPath()).addResourceLocations("file:" + fileUploadProp.getDocBase());
    }


}