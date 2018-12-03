package com.ayigu.blog.controller;

import com.ayigu.blog.entity.Log;
import com.ayigu.blog.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Description: 系统相关操作Controller
 * @Author: chenjun
 * @Date: 2018/11/30 15:30
 */
@RestController
public class SystemController extends BaseController{
    private static String username = "ayigu";
    private static String password = "123456";

    /**
     *登录
     *
     * @param user 登录信息
     * @param request
     * @param response
     * @throws Exception
     */
    @ApiOperation("管理员登录")
    @ApiImplicitParam(name = "user", value = "登录信息", required = true, dataType = "User")
    @PostMapping("login")
    public String login(User user, HttpServletRequest request, HttpServletResponse response) throws Exception{
        //对用户账号进行验证
        if(username.equals(user.getUsername()) && password.equals(user.getPassword())){
            request.getSession().setAttribute("user",user);
            response.sendRedirect(request.getContextPath() + "/admin/index.html");
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
        return null;
    }


    /**
     * 返回所有的日志信息
     *
     * @return 日志列表
     */
    @ApiOperation("返回所有的日志信息")
    @GetMapping("log")
    public List<Log> listAllLog(){
        return systemService.listAllLog();
    }
}
