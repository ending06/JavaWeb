package com.java.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class ErrorPageController extends AbstractController implements InitializingBean {

    @RequestMapping(value = "/ErrorPage.do")
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("server success");
        response.getOutputStream().write("success".getBytes());
        return null;
    }

    public void afterPropertiesSet() throws Exception {
    }
}
