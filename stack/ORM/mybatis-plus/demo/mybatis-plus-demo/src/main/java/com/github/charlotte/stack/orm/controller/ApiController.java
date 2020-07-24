package com.github.charlotte.stack.orm.controller;



import com.github.charlotte.stack.orm.entity.Account;
import com.github.charlotte.stack.orm.service.AccountServiceImpl;
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
    private AccountServiceImpl accountServiceImpl;


    @RequestMapping("/home")
    public Object home(HttpServletRequest request) {

        Account account = accountServiceImpl.getById(1);
        request.getSession().setAttribute("account", account);
        return account;
    }

    @RequestMapping("/session")
    public Object session(HttpServletRequest request) {

        Object account = request.getSession().getAttribute("account");
        return account;
    }

}
