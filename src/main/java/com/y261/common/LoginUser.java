package com.y261.common;

import com.y261.entity.Consumer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 登录态信息：拦截器校验 token 后写入上下文
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements Serializable {

    private static final long serialVersionUID = 1L;

    /** token 字符串 */
    private String token;

    /** 登录用户 id */
    private Integer userId;

    /** 登录用户名 */
    private String username;

    public static LoginUser of(String token, Consumer consumer) {
        return new LoginUser(token,
                consumer == null ? null : consumer.getId(),
                consumer == null ? null : consumer.getUsername());
    }
}
