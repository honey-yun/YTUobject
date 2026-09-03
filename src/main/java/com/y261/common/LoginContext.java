package com.y261.common;

import com.y261.common.LoginUser;

/**
 * 当前登录用户上下文（基于 ThreadLocal，拦截器写入，业务层读取）
 */
public final class LoginContext {

    private static final ThreadLocal<LoginUser> CURRENT = new ThreadLocal<>();

    private LoginContext() {
    }

    public static void set(LoginUser user) {
        CURRENT.set(user);
    }

    public static LoginUser get() {
        return CURRENT.get();
    }

    public static void clear() {
        CURRENT.remove();
    }
}
