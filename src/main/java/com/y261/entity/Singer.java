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
 * 歌手
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("singer")
public class Singer implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField("name")
    private String name;

    /**
     * 性别（0女1男2组合3不明）
     */
    @TableField("sex")
    private Boolean sex;

    /**
     * 头像
     */
    @TableField("pic")
    private String pic;

    /**
     * 生日
     */
    @TableField("birth")
    private LocalDateTime birth;

    /**
     * 地区
     */
    @TableField("location")
    private String location;

    /**
     * 简介
     */
    @TableField("introduction")
    private String introduction;


}
