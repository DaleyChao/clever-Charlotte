package com.github.charlotte.oa.dao;

import com.github.charlotte.oa.entity.Menu;
import com.github.charlotte.oa.entity.MenuExample;
import org.springframework.stereotype.Repository;

/**
 * MenuDAO继承基类
 * @author Daniel
 */
@Repository
public interface MenuDAO extends MyBatisBaseDao<Menu, Integer, MenuExample> {
}