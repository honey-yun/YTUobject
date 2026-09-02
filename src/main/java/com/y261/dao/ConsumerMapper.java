package com.y261.dao;

import com.y261.entity.Consumer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;

/**
 * <p>
 * 前端用户 Mapper 接口
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
public interface ConsumerMapper extends BaseMapper<Consumer> {

    /**
     * 根据用户名查询
     */
    Consumer selectByUsername(@Param("username") String username);

    /**
     * 根据手机号查询
     */
    Consumer selectByPhoneNum(@Param("phoneNum") String phoneNum);

    /**
     * 登录校验（账号 + 密码）
     */
    Consumer selectForLogin(@Param("username") String username, @Param("password") String password);

    /**
     * 根据主键删除（重写以兼容 Serializable）
     */
    @Override
    int deleteById(Serializable id);
}