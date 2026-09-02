package com.y261.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 歌曲
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("song")
public class Song implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 歌手id
     */
    @TableField("singer_id")
    private Integer singerId;

    /**
     * 革命
     */
    @TableField("name")
    private String name;

    /**
     * 简介
     */
    @TableField("introduction")
    private String introduction;

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

    /**
     * 歌曲图片
     */
    @TableField("pic")
    private String pic;

    /**
     * 歌词
     */
    @TableField("lyric")
    private String lyric;

    /**
     * 歌曲地址
     */
    @TableField("url")
    private String url;


}
