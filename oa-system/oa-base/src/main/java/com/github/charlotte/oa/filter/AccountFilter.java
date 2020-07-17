package com.github.charlotte.oa.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户权限处理
 * @author Daniel
 */
@Component
@WebFilter(urlPatterns = "/")
public class AccountFilter implements Filter {
    private final String[] IGNORE_URI = {"index","css","js","login"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //session 中查找 account

        //如果未登录 查看是否在 ignore 中

        String uri = request.getRequestURI();

        System.out.println("uri:"+uri);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        System.out.println("AccountFilter init ****");
    }
}
