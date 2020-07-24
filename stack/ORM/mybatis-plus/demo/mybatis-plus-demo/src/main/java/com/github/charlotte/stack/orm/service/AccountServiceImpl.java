package com.github.charlotte.stack.orm.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.charlotte.stack.orm.dao.AccountDAO;
import com.github.charlotte.stack.orm.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Daniel
 */

@Service
public class AccountServiceImpl extends ServiceImpl<AccountDAO, Account> implements IAccountService {


}
