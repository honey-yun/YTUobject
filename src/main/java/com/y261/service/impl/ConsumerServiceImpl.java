package com.y261.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.y261.entity.Consumer;
import com.y261.dao.ConsumerMapper;
import com.y261.service.IConsumerService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

/**
 * <p>
 * 前端用户 服务实现类
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@Slf4j
@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements IConsumerService {

    @Override
    public IPage<Consumer> pageQuery(long current, long size) {
        Page<Consumer> page = new Page<>(current, size);
        LambdaQueryWrapper<Consumer> wrapper = new LambdaQueryWrapper<>();
        wrapper.orderByDesc(Consumer::getCreateTime);
        return page(page, wrapper);
    }

    @Override
    public IPage<Consumer> pageByKeyword(String keyword, long current, long size) {
        Page<Consumer> page = new Page<>(current, size);
        LambdaQueryWrapper<Consumer> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(keyword)) {
            wrapper.like(Consumer::getUsername, keyword);
        }
        wrapper.orderByDesc(Consumer::getCreateTime);
        return page(page, wrapper);
    }

    @Override
    public IPage<Consumer> pageByCondition(String username, String phone, Boolean sex, String location,
                                           long current, long size) {
        Page<Consumer> page = new Page<>(current, size);
        LambdaQueryWrapper<Consumer> wrapper = new LambdaQueryWrapper<>();
        if (StringUtils.hasText(username)) {
            wrapper.like(Consumer::getUsername, username);
        }
        if (StringUtils.hasText(phone)) {
            wrapper.like(Consumer::getPhoneNum, phone);
        }
        if (sex != null) {
            wrapper.eq(Consumer::getSex, sex);
        }
        if (StringUtils.hasText(location)) {
            wrapper.like(Consumer::getLocation, location);
        }
        wrapper.orderByDesc(Consumer::getCreateTime);
        return page(page, wrapper);
    }

    @Override
    public Consumer selectByUsername(String username) {
        if (!StringUtils.hasText(username)) {
            return null;
        }
        return baseMapper.selectByUsername(username);
    }

    @Override
    public Consumer selectByPhoneNum(String phoneNum) {
        if (!StringUtils.hasText(phoneNum)) {
            return null;
        }
        return baseMapper.selectByPhoneNum(phoneNum);
    }

    @Override
    public Consumer login(String username, String password) {
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            return null;
        }
        return baseMapper.selectForLogin(username, password);
    }

    @Override
    public boolean register(Consumer consumer) {
        if (consumer == null) {
            return false;
        }
        if (!StringUtils.hasText(consumer.getUsername()) || !StringUtils.hasText(consumer.getPassword())) {
            return false;
        }
        // 账号唯一性校验
        if (baseMapper.selectByUsername(consumer.getUsername()) != null) {
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        if (consumer.getCreateTime() == null) {
            consumer.setCreateTime(now);
        }
        consumer.setUpdateTime(now);
        return save(consumer);
    }

    @Override
    public boolean updateConsumer(Consumer consumer) {
        if (consumer == null || consumer.getId() == null) {
            return false;
        }
        consumer.setUpdateTime(LocalDateTime.now());
        return updateById(consumer);
    }

    @Override
    public boolean deleteConsumer(Integer id) {
        if (id == null) {
            return false;
        }
        return removeById(id);
    }

    @Override
    public boolean deleteBatch(java.util.List<Integer> ids) {
        if (ids == null || ids.isEmpty()) {
            return false;
        }
        return removeByIds(ids);
    }
}