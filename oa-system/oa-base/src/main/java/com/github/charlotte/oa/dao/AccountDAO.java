package com.github.charlotte.oa.dao;

import com.github.charlotte.oa.entity.Account;
import com.github.charlotte.oa.entity.AccountExample;
import org.springframework.stereotype.Repository;

/**
 * AccountDAO继承基类
 * @author Daniel
 */
@Repository
public interface AccountDAO extends MyBatisBaseDao<Account, Integer, AccountExample> {
}