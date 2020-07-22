package com.github.charlotte.oa.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 系统配置相关
 * @author Daniel
 *
 */
@Component
public class Config {

	@Value(value = "${config.systemName}")
	private String systemName;

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}
}
