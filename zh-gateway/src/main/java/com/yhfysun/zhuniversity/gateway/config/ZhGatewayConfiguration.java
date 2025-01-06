package com.yhfysun.zhuniversity.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author yhfysun
 * @createTime 2024/6/19 下午 19:22
 */
@Configuration
public class ZhGatewayConfiguration {
	
	/** 
	 * 配置跨域
	 * @author yaoyang_han
	 * @createTime 2024/7/20 上午 10:20
	 **/
	@Bean
	public CorsWebFilter corsWebFilter() {
		UrlBasedCorsConfigurationSource  source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		// 配置跨域
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addAllowedOriginPattern("*");
		corsConfiguration.setAllowCredentials(true);
		source.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsWebFilter(source);
	}
	
}
