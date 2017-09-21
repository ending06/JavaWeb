package com.java.spring.jstack;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

//--------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/8/12<p>
//-------------------------------------------------------
public class JavaWebTest extends AbstractController {

    @Autowired
    private StackOutOfMemory stackOutOfMemory;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("server success");
        func1();
        response.getOutputStream().write("success".getBytes());
        return null;
    }

    private void func1() {
        System.out.println("server func1 start");
        stackOutOfMemory.newThread();
/*        int a = 0;
        while(true){
            int b = 10;
            int c = 11;
            a = b+c;
        }*/
        System.out.println("server func1 end");

    }
}
