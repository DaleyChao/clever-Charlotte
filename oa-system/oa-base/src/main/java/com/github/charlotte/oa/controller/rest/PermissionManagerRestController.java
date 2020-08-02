package com.github.charlotte.oa.controller.rest;

import com.github.charlotte.oa.entity.Permission;
import com.github.charlotte.oa.service.PermissionService;
import com.github.charlotte.oa.vo.RespStat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * restful风格URI的controller
 * 只和用户交换JSON数据
 * @author Administrator
 *
 */

@RestController
@RequestMapping("/api/v1/manager/permission")
public class PermissionManagerRestController {
	
	@Autowired
	PermissionService permissionSrv;
	
	/**
	 * 更新
	 * @param permission
	 * @return
	 */
	@RequestMapping("add")
	public RespStat add(@RequestBody Permission permission) {
		
		System.out.println("permission:" + ToStringBuilder.reflectionToString(permission));
	
		
		if(permission.getId() == null ) {
			
			permissionSrv.add(permission);
			
			
		}else {
			permissionSrv.update(permission);
		}
		
		
		return RespStat.build(200);
	}
	@RequestMapping("update")
	public RespStat update(@RequestBody Permission permission) {
		
		System.out.println("permission:" + ToStringBuilder.reflectionToString(permission));
		permissionSrv.update(permission);
		return RespStat.build(200);
	}
	
	
}
