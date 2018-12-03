package com.ayigu.blog.interceptor;

import com.ayigu.blog.entity.User;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description: 拦截后台请求的拦截器
 * @Author: chenjun
 * @Date: 2018/11/29 16:22
 */
public class BackInterceptor implements HandlerInterceptor {
    private String username = "ayigu";
    private String password = "12345";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean flag;
        User user = (User) request.getSession().getAttribute("user");
        if(user == null){
            request.getRequestDispatcher(request.getContextPath() + "/error.html").forward(request,response);
            flag = false;
        } else {
            if (username.equals(user.getUsername()) && password.equals(user.getPassword())){
                flag = true;
            } else {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
