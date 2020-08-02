package com.github.charlotte.oa.dao;

import com.github.charlotte.oa.entity.Permission;
import com.github.charlotte.oa.entity.PermissionExample;
import org.springframework.stereotype.Repository;

/**
 * PermissionDAO继承基类
 */
@Repository
public interface PermissionDAO extends MyBatisBaseDao<Permission, Integer, PermissionExample> {
}