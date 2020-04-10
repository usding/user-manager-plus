package fc.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SessionFilter implements Filter {
    protected Logger log = LoggerFactory.getLogger(SessionFilter.class);
    // 不登陆也可以访问的资源
    private static Set<String> GreenUrlSet = new HashSet<>();

    //普通用户没有权限访问的资源
    private static String NoAuthUri ="/user/";

    @Override
    public void doFilter(ServletRequest srequest, ServletResponse sresponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) srequest;
        String uri = request.getRequestURI();
        sresponse.setCharacterEncoding("UTF-8");//设置响应编码格式
        sresponse.setContentType("text/html;charset=UTF-8");//设置响应编码格式
        if (uri.endsWith(".js")
                || uri.endsWith(".css")
                || uri.endsWith(".jpg")
                || uri.endsWith(".gif")
                || uri.endsWith(".png")
                || uri.endsWith(".ico")) {
            log.debug("security filter, pass, " + request.getRequestURI());
            filterChain.doFilter(srequest, sresponse);
            return;
        }

        System.out.println("request uri is : "+uri);
        //不处理指定的action, jsp
        if (GreenUrlSet.contains(uri) || uri.contains("/verified/")) {
            log.debug("security filter, pass, " + request.getRequestURI());
            filterChain.doFilter(srequest, sresponse);
            return;
        }
        Integer id= (Integer) request.getSession().getAttribute(WebConfiguration.LOGIN_KEY);
        Integer role = (Integer) request.getSession().getAttribute(WebConfiguration.LOGIN_ROLE);
        if(StringUtils.isEmpty(id)){
        	String html = "<script type=\"text/javascript\">window.location.href=\"/toLogin\"</script>";
            sresponse.getWriter().write(html);
        }else if (role==1&& uri.contains(NoAuthUri)){
            String html = "<script type=\"text/javascript\">window.location.href=\"/student/studentList\"</script>";
            sresponse.getWriter().write(html);
        }else {
            filterChain.doFilter(srequest, sresponse);
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterconfig) throws ServletException {
        GreenUrlSet.add("/toRegister");
        GreenUrlSet.add("/toLogin");
        GreenUrlSet.add("/login");
        GreenUrlSet.add("/loginOut");
        GreenUrlSet.add("/register");
        GreenUrlSet.add("/verified");


    }
}
