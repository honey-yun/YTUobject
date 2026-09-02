package com.y261.controller;

import com.y261.entity.Consumer;
import com.y261.service.IConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端用户 前端控制器
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private IConsumerService consumerService;

    /**
     * 查询所有用户
     */
    @GetMapping("/all")
    public List<Consumer> all() {
        return consumerService.list();
    }

    /**
     * 根据主键查询
     */
    @GetMapping("/detail/{id}")
    public Consumer detail(@PathVariable Integer id) {
        return consumerService.getById(id);
    }

    /**
     * 根据用户名查询
     */
    @GetMapping("/username")
    public Consumer byUsername(@RequestParam String username) {
        return consumerService.selectByUsername(username);
    }

    /**
     * 更新用户
     */
    @PostMapping("/update")
    public boolean update(@RequestBody Consumer consumer) {
        return consumerService.updateConsumer(consumer);
    }

    /**
     * 根据id删除用户
     */
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable Integer id) {
        return consumerService.deleteConsumer(id);
    }

    /**
     * 新增用户
     */
    @PostMapping("/save")
    public boolean save(@RequestBody Consumer consumer) {
        return consumerService.save(consumer);
    }

    /**
     * 保存或更新用户
     */
    @PostMapping("/saveOrUpdate")
    public boolean saveOrUpdate(@RequestBody Consumer consumer) {
        return consumerService.saveOrUpdate(consumer);
    }
}