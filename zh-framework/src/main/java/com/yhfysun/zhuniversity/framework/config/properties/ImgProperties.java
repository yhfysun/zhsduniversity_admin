package com.yhfysun.zhuniversity.framework.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("img-protect")
@Data
public class ImgProperties {
	
	private boolean enabled;
	
	private boolean allowBrowser;
	
	private String allowReferer;
	
}

