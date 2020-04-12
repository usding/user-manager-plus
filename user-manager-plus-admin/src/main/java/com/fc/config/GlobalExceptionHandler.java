package com.fc.config;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 18220
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public JSONObject defaultErrorHandler(Exception e, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        logger.info("request url：" + request.getRequestURL());
        JSONObject jo = new JSONObject();
        jo.put("exception", e.getMessage());
        jo.put("url", request.getRequestURL());
        logger.error("exception：", e);
        return jo;
    }
}