package com.yhfysun.zhuniversity.framework.interceptor;

import com.yhfysun.zhuniversity.common.utils.StringUtils;
import com.yhfysun.zhuniversity.framework.config.properties.ImgProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class ImageProtectionInterceptor implements HandlerInterceptor {
	
	@Autowired
	private ImgProperties imgProperties;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {  // 判断是否开启图片防盗链功能        
		
		if (!imgProperties.isEnabled()) {
			return true;
		}                
		// 获取请求的 URL
		String requestUrl = request.getRequestURL().toString();        
		// 判断请求是否以图片后缀结尾
		if (requestUrl.endsWith(".m3u8")) {            
			// 获取请求的来源域名
			String referer = request.getHeader("Referer");
			// 检查来源域名是否符合预期,referer 为 null 则说明是浏览器直接访问。
			if (StringUtils.isEmpty(referer) && imgProperties.isAllowBrowser()) {
				// 符合防盗链要求，放行请求
				return true; 
				
			} else if (isVideoTagRequest(request) && StringUtils.isNotEmpty(referer) && isAllowedDomain(referer)) {
				// 符合防盗链要求，放行请求
				return true; 
			} else {
				// 返回 403 Forbidden
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				// 拦截请求
				return false; 
			}
		}
		// 对非图片资源请求放行
		return true; 
	}
	
	private boolean isVideoTagRequest(HttpServletRequest request) {
		String acceptHeader = request.getHeader("Accept");
		// && acceptHeader.contains("video/")
		if (acceptHeader != null) {
			String rangeHeader = request.getHeader("Range");
			if (rangeHeader == null) {
				return true;
			}
		}
		return false;
	}
	
	/** 
	 * 检查是否来自允许的域名
	 * @author yaoyang_han
	 * @createTime 2024/7/21 上午 10:46
	 **/
	private boolean isAllowedDomain(String referer) {
		// 获取允许的域名        
		String allowedReferers = imgProperties.getAllowReferer();
		// 如果允许的域名不为空        
		if (allowedReferers.trim() != null && !"".equals(allowedReferers.trim())) {
			// 将允许的域名分割成字符串数组            
			Set<String> allowedDomains = new HashSet<>(Arrays.asList(allowedReferers.split(",")));
			// 遍历允许的域名            
			for (String allowedDomain : allowedDomains) {
				// 如果请求的域名包含允许的域名，则返回true                
				if (referer.contains(allowedDomain.trim())) {
					return true;
				}
			}
		}
		// 否则返回 false
		return false;
	}
}

