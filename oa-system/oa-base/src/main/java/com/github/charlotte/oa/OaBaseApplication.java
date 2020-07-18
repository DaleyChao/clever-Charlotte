package com.github.charlotte.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Daniel
 */
@SpringBootApplication
@MapperScan(value = "com.github.charlotte.oa.dao")
public class OaBaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(OaBaseApplication.class, args);
	}

}
