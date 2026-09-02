package com.y261.service.impl;

import com.y261.entity.Admin;
import com.y261.dao.AdminMapper;
import com.y261.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
