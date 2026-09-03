package com.y261.controller;

import com.y261.common.Result;
import com.y261.entity.Consumer;
import com.y261.service.IConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 * 前端用户 前端控制器
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@Slf4j
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private IConsumerService consumerService;

    /**
     * 查询所有用户
     */
    @GetMapping("/all")
    public Result<List<Consumer>> all() {
        List<Consumer> list = consumerService.list();
        return Result.success("查询成功", list);
    }

    /**
     * 根据id查询用户
     */
    @GetMapping("/detail/{id}")
    public Result<Consumer> detail(@PathVariable Integer id) {
        Consumer consumer = consumerService.getById(id);
        if (consumer == null) {
            return Result.error("用户不存在");
        }
        return Result.success("查询成功", consumer);
    }

    /**
     * 根据用户名查询
     */
    @GetMapping("/username")
    public Result<Consumer> byUsername(@RequestParam String username) {
        Consumer consumer = consumerService.selectByUsername(username);
        if (consumer == null) {
            return Result.error("用户不存在");
        }
        return Result.success("查询成功", consumer);
    }

    /**
     * 根据手机号查询
     */
    @GetMapping("/phone")
    public Result<Consumer> byPhoneNum(@RequestParam String phoneNum) {
        Consumer consumer = consumerService.selectByPhoneNum(phoneNum);
        if (consumer == null) {
            return Result.error("用户不存在");
        }
        return Result.success("查询成功", consumer);
    }

    /**
     * 登录验证
     * <p>
     * 登录成功生成 token，原本要把 token 存到 Redis，这部分先注释掉（TODO），
     * 等本地装好 Redis 后把 StringRedisTemplate 注入回来即可启用。
     */
    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestParam String username, @RequestParam String password) {
        Consumer consumer = consumerService.login(username, password);
        if (consumer == null) {
            return Result.error("用户名或密码错误");
        }

        // 1. 生成 token
        String token = UUID.randomUUID().toString().replace("-", "");
        long expireSeconds = 30 * 60L; // 30 分钟

        // TODO: 本地装好 Redis 后，把下面这段打开，把 token 存到 Redis
        // String key = "login:token:" + token;
        // String json = objectMapper.writeValueAsString(LoginUser.of(token, consumer));
        // stringRedisTemplate.opsForValue().set(key, json, Duration.ofSeconds(expireSeconds));

        log.info("用户 [{}] 登录成功，token={}", username, token);

        // 2. 响应里把 token 和脱敏后的用户信息一起返回
        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        data.put("expireSeconds", expireSeconds);
        Consumer safe = new Consumer();
        safe.setId(consumer.getId());
        safe.setUsername(consumer.getUsername());
        safe.setSex(consumer.getSex());
        safe.setPhoneNum(consumer.getPhoneNum());
        safe.setEmail(consumer.getEmail());
        safe.setBirth(consumer.getBirth());
        safe.setIntroduction(consumer.getIntroduction());
        safe.setLocation(consumer.getLocation());
        safe.setAvator(consumer.getAvator());
        safe.setCreateTime(consumer.getCreateTime());
        safe.setUpdateTime(consumer.getUpdateTime());
        data.put("user", safe);

        return Result.success("登录成功", data);
    }

    /**
     * 新增用户
     */
    @PostMapping("/save")
    public Result<String> save(@RequestBody Consumer consumer) {
        boolean saved = consumerService.save(consumer);
        if (saved) {
            return Result.success("用户添加成功");
        }
        return Result.error("用户添加失败");
    }

    /**
     * 保存或更新用户
     */
    @PostMapping("/saveOrUpdate")
    public Result<String> saveOrUpdate(@RequestBody Consumer consumer) {
        boolean result = consumerService.saveOrUpdate(consumer);
        if (result) {
            return Result.success("操作成功");
        }
        return Result.error("操作失败");
    }

    /**
     * 更新用户
     */
    @PostMapping("/update")
    public Result<String> update(@RequestBody Consumer consumer) {
        boolean updated = consumerService.updateConsumer(consumer);
        if (updated) {
            return Result.success("用户更新成功");
        }
        return Result.error("用户更新失败");
    }

    /**
     * 根据id删除用户
     */
    @DeleteMapping("/delete/{id}")
    public Result<String> delete(@PathVariable Integer id) {
        boolean deleted = consumerService.deleteConsumer(id);
        if (deleted) {
            return Result.success("用户删除成功");
        }
        return Result.error("用户删除失败");
    }

}
