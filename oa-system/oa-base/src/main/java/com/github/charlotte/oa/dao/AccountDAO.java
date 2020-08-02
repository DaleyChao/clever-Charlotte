package com.github.charlotte.oa.dao;

import com.github.charlotte.oa.entity.Account;
import com.github.charlotte.oa.entity.AccountExample;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AccountDAO继承基类
 * @author Daniel
 */
@Repository
public interface AccountDAO extends MyBatisBaseDao<Account, Integer, AccountExample> {
    List<Account> selectByPermission();

    Account findByLoginNameAndPassword(String loginName, String password);

}