package com.java.spring.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/14<p>
// -------------------------------------------------------
@Controller
public class UserLoginIn extends AbstractController {
    @RequestMapping(value = "/loginIn.do")
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //获取表单提交数据
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        //创建模型视图对象用来返回
        ModelAndView mav = new ModelAndView();

        if("admin".equals(userName) && "admin".equals(userPwd)){
            //将页面需要使用的数据保存
            mav.addObject("currentUserName", userName);
            //设置视图名称
            mav.setViewName("/index.jsp");
        }
        else{
            mav.addObject("error", "用户名或密码错误");
            mav.setViewName("/login.jsp");
        }

        return mav;
    }
}
