package com.github.charlotte.oa.service;

import java.util.List;

import com.github.charlotte.oa.dao.PermissionDAO;
import com.github.charlotte.oa.entity.Permission;
import com.github.charlotte.oa.entity.PermissionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;



/**
 * @author Daniel
 */
@Service
public class PermissionService {

	@Autowired
	PermissionDAO pMapper;
	
	public PageInfo<Permission> findByPage(int pageNum, int pageSize) {

		PageHelper.startPage(pageNum, pageSize);
		
		PermissionExample example = new PermissionExample();
		List<Permission> list = pMapper.selectByExample(example );
		
		return new PageInfo<>(list);
	}

	public Permission findById(int id) {

		return pMapper.selectByPrimaryKey(id);
	}

	public void update(Permission permission) {
		// TODO Auto-generated method stub
		pMapper.updateByPrimaryKeySelective(permission);
		
	}

	public void add(Permission permission) {
		// TODO Auto-generated method stub
		
		
		pMapper.insert(permission);
	}

	public List<Permission> findAll() {

		PermissionExample example = new PermissionExample();
		return pMapper.selectByExample(example);
	}

}
