package com.fc.config;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 18220
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    protected Logger logger =  LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public JSONObject defaultErrorHandler(Exception e, HttpServletRequest request) throws Exception {
        logger.info("request url：" + request.getRequestURL());
        JSONObject jo = new JSONObject();
        jo.put("exception",e.getMessage());
        jo.put("url",request.getRequestURL());
        logger.error("exception：",e);
        return jo;
    }
}