package com.github.charlotte.oa.service;

import com.github.charlotte.oa.dao.AccountDAO;
import com.github.charlotte.oa.entity.Account;
import com.github.charlotte.oa.entity.AccountExample;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Daniel
 */

@Service
public class AccountService {

    @Autowired
    private AccountDAO accountDAO;

    public List<Account> findByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        AccountExample example = new AccountExample();
        return accountDAO.selectByExample(example);
    }

}
