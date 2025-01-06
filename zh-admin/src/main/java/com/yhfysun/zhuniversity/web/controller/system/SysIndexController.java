package com.yhfysun.zhuniversity.web.controller.system;

import com.yhfysun.zhuniversity.common.config.YhfysunConfig;
import com.yhfysun.zhuniversity.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页
 *
 * @author yhfysun
 */
@RestController
public class SysIndexController
{
    /** 系统基础配置 */
    @Autowired
    private YhfysunConfig YhfysunConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index()
    {
        return StringUtils.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。", YhfysunConfig.getName(), YhfysunConfig.getVersion());
    }
}
