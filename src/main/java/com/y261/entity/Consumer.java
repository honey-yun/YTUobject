package com.y261.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 前端用户
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("consumer")
public class Consumer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    @TableField("username")
    private String username;

    /**
     * 密码
     */
    @TableField("password")
    private String password;

    /**
     * 性别（1男0女）
     */
    @TableField("sex")
    private Boolean sex;

    /**
     * 电话
     */
    @TableField("phone_num")
    private String phoneNum;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 生日
     */
    @TableField("birth")
    private LocalDateTime birth;

    /**
     * 签名
     */
    @TableField("introduction")
    private String introduction;

    /**
     * 地区
     */
    @TableField("location")
    private String location;

    /**
     * 头像
     */
    @TableField("avator")
    private String avator;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;


}
