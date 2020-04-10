package com.fc.config;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fc.result.Result;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class SessionInterceptor implements HandlerInterceptor {

    List<String> whitelist;

    SessionInterceptor() throws IOException {
        ClassPathResource resource = new ClassPathResource("whitelist.json");
        JSONArray obj = JSONObject.parseArray(IOUtils.toString(resource.getInputStream(), StandardCharsets.UTF_8));
        whitelist = obj.toJavaList(String.class);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String uri = request.getRequestURI();
        for (String path : whitelist) {
            if (uri.startsWith(path)) {
                return true;
            }
        }
        if (uri.contains(".")) {
            return true;
        }

        Integer id = (Integer) request.getSession().getAttribute(WebConfiguration.LOGIN_KEY);
        Integer role = (Integer) request.getSession().getAttribute(WebConfiguration.LOGIN_ROLE);
        if (id != null) {
            return true;
        }
        Result res = Result.ofFail(-1, "not singed in");
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(JSONObject.toJSONString(res));
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

    }
}
