package com.github.charlotte.oa.controller;


import com.github.charlotte.oa.dao.AccountDAO;
import com.github.charlotte.oa.entity.Account;
import com.github.charlotte.oa.entity.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Daniel
 */
@Controller
@RequestMapping("/api")
@ResponseBody
public class ApiController {

    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private Config config;


    @RequestMapping("/home")
    public Object home(HttpServletRequest request){

        Account account = accountDAO.selectByPrimaryKey(1);
        request.getSession().setAttribute("account",account);
        return account;
    }

    @RequestMapping("/session")
    public Object session(HttpServletRequest request){

        Object account = request.getSession().getAttribute("account");
        return account;
    }

    @RequestMapping("/config")
    public Object config(HttpServletRequest request){
        return config.getSystemName();
    }
}
