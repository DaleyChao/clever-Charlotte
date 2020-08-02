package com.github.charlotte.oa.controller.rest;

import com.github.charlotte.oa.service.RoleService;
import com.github.charlotte.oa.vo.RespStat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * restful风格URI的controller
 * 只和用户交换JSON数据
 * @author Administrator
 *
 */

@RestController
@RequestMapping("/api/v1/manager/role")
public class RoleManagerRestController {
	
	@Autowired
	RoleService roleSrv;

	@RequestMapping("Permission/add")
	public RespStat permissionadd(
			@RequestParam int[] permissions,
			@RequestParam int id
			) {
		//insert into role_permission (role_id,permission_id) values (6,1)
	
		
		roleSrv.addPermission(id,permissions);
		System.out.println("permissionids:" + ToStringBuilder.reflectionToString(permissions));
		return RespStat.build(200);
		
	}
	
	
}
