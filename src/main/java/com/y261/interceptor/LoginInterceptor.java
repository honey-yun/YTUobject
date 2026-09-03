package com.y261.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.y261.common.LoginUser;
import com.y261.common.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

/**
 * 登录拦截器
 * <p>
 * 1. 从请求头读取 token（Authorization: Bearer xxx 或直接传 X-Token）
 * 2. 根据 token 从 Redis 取出登录用户
 * <p>
 * Redis 部分已用 TODO 注释掉，本地没装 Redis 时可直接跑（不校验登录态，只放行）
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 跨域预检请求直接放行
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        String token = resolveToken(request);
        if (token == null || token.isEmpty()) {
            return reject(response, "未登录，请先登录");
        }

        LoginUser loginUser = null;
        // TODO: 本地装好 Redis 后，把下面这段打开，从 Redis 读取登录用户
        // String key = "login:token:" + token;
        // String json = stringRedisTemplate.opsForValue().get(key);
        // if (json != null) {
        //     loginUser = objectMapper.readValue(json, LoginUser.class);
        // }

        if (loginUser == null) {
            return reject(response, "登录已过期，请重新登录");
        }

        // 写入线程上下文，业务层可通过 LoginContext.get() 获取
        LoginContext.set(loginUser);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        LoginContext.clear();
    }

    private String resolveToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return request.getHeader("X-Token");
    }

    private boolean reject(HttpServletResponse response, String message) throws Exception {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        try (PrintWriter writer = response.getWriter()) {
            writer.write(objectMapper.writeValueAsString(Result.error(401, message)));
            writer.flush();
        }
        return false;
    }
}
