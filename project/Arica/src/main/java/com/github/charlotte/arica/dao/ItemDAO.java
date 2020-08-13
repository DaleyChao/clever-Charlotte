package com.github.charlotte.arica.dao;

import com.github.charlotte.arica.entity.Item;
import com.github.charlotte.arica.entity.ItemExample;
import org.springframework.stereotype.Repository;

/**
 * ItemDAO继承基类
 */
@Repository
public interface ItemDAO extends MyBatisBaseDao<Item, Integer, ItemExample> {
}