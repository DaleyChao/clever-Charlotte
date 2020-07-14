package com.github.charlotte.oa.controller;

import com.github.charlotte.oa.entity.Account;
import com.github.charlotte.oa.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Daniel
 */
@Controller
@RequestMapping("/account")
@ResponseBody
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping("/page")
    public Object page (@RequestParam(required = false) Integer pageNum, @RequestParam(required = false) Integer pageSize) {

        return accountService.findByPage(pageNum,pageSize);
    }
}
