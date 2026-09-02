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
 * 收藏
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("collect")
public class Collect implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 收藏类型（0歌曲1歌单）
     */
    @TableField("type")
    private Boolean type;

    /**
     * 歌曲id
     */
    @TableField("song_id")
    private Integer songId;

    /**
     * 歌单id
     */
    @TableField("song_list_id")
    private Integer songListId;

    /**
     * 收藏时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;


}
