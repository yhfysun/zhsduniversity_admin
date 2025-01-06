package com.yhfysun.zhuniversity.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author yaoyang_han
 * @createTime 2024/7/20 上午 9:30
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ZhGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ZhGatewayApplication.class, args);
	}
}
