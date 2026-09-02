package com.y261.service.impl;

import com.y261.entity.Comment;
import com.y261.dao.CommentMapper;
import com.y261.service.ICommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论 服务实现类
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements ICommentService {

}
