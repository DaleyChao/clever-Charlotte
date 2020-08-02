package com.github.charlotte.oa.dao;

import com.github.charlotte.oa.entity.Role;
import com.github.charlotte.oa.entity.RoleExample;
import org.springframework.stereotype.Repository;

/**
 * RoleDAO继承基类
 */
@Repository
public interface RoleDAO extends MyBatisBaseDao<Role, Integer, RoleExample> {
    void addPermission(int id, int permission);

    void addPermissions(int id, int[] permissions);

    Role findById(int id);

}