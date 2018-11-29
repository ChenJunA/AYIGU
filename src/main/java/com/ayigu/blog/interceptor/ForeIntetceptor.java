package com.ayigu.blog.interceptor;

import com.ayigu.blog.entity.Log;
import com.ayigu.blog.util.BrowserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 拦截前台请求的拦截器
 * @Author: chenjun
 * @Date: 2018/11/29 16:22
 */
public class ForeIntetceptor implements HandlerInterceptor {
    @Autowired
    private Log log = new Log();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //访问者IP
        String ip = request.getRemoteAddr();
        //请求地址
        String url = request.getRequestURL().toString();
        //浏览器名
        String browser = BrowserUtil.getOsAndBrowserInfo(request);

        log.setIp(StringUtils.isEmpty(ip) ? "0.0.0.0" : ip);
        log.setUrl(StringUtils.isEmpty(url) ? "获取请求地址失败" : url);
        log.setBrowser(StringUtils.isEmpty(browser) ? "获取浏览器失败" : browser);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
