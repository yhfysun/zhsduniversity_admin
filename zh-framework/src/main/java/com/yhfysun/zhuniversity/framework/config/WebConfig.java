package com.yhfysun.zhuniversity.framework.config;

import com.yhfysun.zhuniversity.framework.interceptor.ImageProtectionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private ImageProtectionInterceptor imageProtectionInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		// 注册拦截器，拦截所有请求        
		registry.addInterceptor(imageProtectionInterceptor)
				.addPathPatterns("/**");
	}
	
}
