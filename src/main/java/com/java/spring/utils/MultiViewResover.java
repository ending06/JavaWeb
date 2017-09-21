package com.java.spring.utils;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;
import java.util.Map;

// --------------------- Change Logs----------------------
// <p>@author ruirui.qu Initial Created at 17/9/14<p>
// -------------------------------------------------------
public class MultiViewResover implements ViewResolver {
    private Map<String, ViewResolver> resolvers;

    @Override
    public View resolveViewName(String viewName, Locale locale) throws Exception {
        // 获取viewName(modelAndView中的名字)看其有没有"."+扩展名
        int n = viewName.lastIndexOf(".");
        String suffix = "";
        String originalViewName = viewName;

        // 没有"."默认使用“jsp“方式解析,有的话截取扩展名jsp、vm...与配置文件中的<entry key="vm">的key匹配
        if (n == (-1)) {
            suffix = "jsp";
        } else {
            suffix = viewName.substring(n + 1);
            // 取资源名.跟到当前访问路径除去扩展后缀名
            viewName = viewName.substring(0, n);
        }

        // 根据扩展名去获取视图对应的解析对象<entry key="xxx">
        ViewResolver resolver = resolvers.get(suffix);

        if (resolver != null) {
            return resolver.resolveViewName(viewName, locale);
        } else {
            //默认使用jsp的viewResolver
            resolver = resolvers.get("jsp");
            if (resolver == null) {
                return null;
            }
            return resolver.resolveViewName(originalViewName, locale);
        }
    }

    public Map<String, ViewResolver> getResolvers() {
        return resolvers;
    }

    public void setResolvers(Map<String, ViewResolver> resolvers) {
        this.resolvers = resolvers;
    }
}
