package com.y261.config;

import com.y261.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 注册登录拦截器
 * <p>
 * 跨域配置见 {@link CrosConfig}
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                // 需要登录才能访问的接口
                .addPathPatterns(
                        "/consumer/detail/**",
                        "/consumer/update",
                        "/consumer/delete/**",
                        "/comment/**",
                        "/collect/**",
                        "/rank/**"
                )
                // 这些路径直接放行
                .excludePathPatterns(
                        "/consumer/login",
                        "/consumer/all",
                        "/consumer/username",
                        "/consumer/phone",
                        "/consumer/save",
                        "/consumer/saveOrUpdate",
                        "/song/**",
                        "/singer/**",
                        "/songList/**",
                        "/listSong/**",
                        "/admin/**"
                );
    }
}
