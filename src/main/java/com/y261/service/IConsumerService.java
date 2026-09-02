package com.y261.service;

import com.y261.entity.Consumer;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 前端用户 服务类
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
public interface IConsumerService extends IService<Consumer> {

    /**
     * 根据用户名查询
     */
    Consumer selectByUsername(String username);

    /**
     * 根据手机号查询
     */
    Consumer selectByPhoneNum(String phoneNum);

    /**
     * 登录校验
     *
     * @return 登录成功返回 Consumer，失败返回 null
     */
    Consumer login(String username, String password);

    /**
     * 注册（新增用户），会自动维护 createTime/updateTime
     */
    boolean register(Consumer consumer);

    /**
     * 更新用户
     */
    boolean updateConsumer(Consumer consumer);

    /**
     * 根据主键删除
     */
    boolean deleteConsumer(Integer id);
}