package com.y261.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
     * 分页查询用户
     */
    IPage<Consumer> pageQuery(long current, long size);

    /**
     * 按用户名关键字分页查询（模糊匹配）
     */
    IPage<Consumer> pageByKeyword(String keyword, long current, long size);

    /**
     * 多条件模糊分页查询（任一字段为空则忽略该条件，AND 连接）
     *
     * @param username 用户名关键字
     * @param phone    电话关键字
     * @param sex      性别（1男0女，null 表示不限）
     * @param location 地址关键字
     */
    IPage<Consumer> pageByCondition(String username, String phone, Boolean sex, String location,
                                    long current, long size);

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

    /**
     * 批量删除
     */
    boolean deleteBatch(java.util.List<Integer> ids);
}