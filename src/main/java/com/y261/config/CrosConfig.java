package com.y261.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 全局跨域配置
 * <p>
 * 跨域的处理方式：[注解(全局、局部)，配置文件]
 */
@Configuration
public class CrosConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("http://localhost:5173")
                .allowedMethods("GET", "POST", "DELETE", "PUT", "OPTIONS", "PATCH")
                .exposedHeaders("Authorization")
                .allowCredentials(true) // 与 allowedOriginPatterns("*") 冲突，会导致无法获取 token
                .allowedHeaders("*")
                .maxAge(3600);
    }
}
