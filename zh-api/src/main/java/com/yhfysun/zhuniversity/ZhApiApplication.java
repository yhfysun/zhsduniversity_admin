package com.yhfysun.zhuniversity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class }, scanBasePackages ={"com.yhfysun.zhuniversity"})
@MapperScan("com.yhfysun.zhuniversity.system.mapper")
public class ZhApiApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ZhApiApplication.class, args);
	}
	
}
