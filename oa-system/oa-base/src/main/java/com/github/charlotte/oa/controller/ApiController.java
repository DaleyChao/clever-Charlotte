package com.github.charlotte.oa.controller;


import com.github.charlotte.oa.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Daniel
 */
@Controller
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private AccountDAO accountDAO;

    @RequestMapping("/home")
    @ResponseBody
    public Object home(){

        return accountDAO.selectByPrimaryKey(1);

    }
}
