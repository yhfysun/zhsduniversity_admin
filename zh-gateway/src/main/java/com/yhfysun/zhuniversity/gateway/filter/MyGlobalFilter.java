
package com.yhfysun.zhuniversity.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
 
public class MyGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 拦截逻辑
        System.out.println("拦截到请求: " + exchange.getRequest().getPath());
        
        // 你可以在这里添加你的拦截逻辑
        // 如果你想拦截请求继续传递给后端服务，请调用chain.filter(exchange)
        // 如果你想中断请求，返回自定义响应，请不调用chain.filter(exchange)
 
        return chain.filter(exchange); // 继续传递给下一个过滤器或路由
    }
 
    @Override
    public int getOrder() {
        // 定义全局过滤器的顺序，数字越小，优先级越高
        return -1; // 确保这个过滤器是最先执行的
    }
}