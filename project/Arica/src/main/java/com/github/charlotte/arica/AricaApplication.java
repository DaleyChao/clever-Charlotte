package com.github.charlotte.arica;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Daniel
 */
@SpringBootApplication
@MapperScan(value = "com.github.charlotte.arica.dao")
public class AricaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AricaApplication.class, args);
	}

}
