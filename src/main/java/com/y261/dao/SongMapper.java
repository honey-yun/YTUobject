package com.y261.dao;

import com.y261.entity.Song;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 歌曲 Mapper 接口
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
public interface SongMapper extends BaseMapper<Song> {

    /**
     * 根据歌曲名模糊查询
     */
    List<Song> selectByName(@Param("name") String name);

    /**
     * 根据歌手ID查询该歌手的所有歌曲
     */
    List<Song> selectBySingerId(@Param("singerId") Integer singerId);

    /**
     * 根据歌单ID查询歌单中的所有歌曲（需要联表 list_song）
     */
    List<Song> selectBySongListId(@Param("songListId") Integer songListId);

    /**
     * 根据主键删除（重写以兼容 Serializable）
     */
    @Override
    int deleteById(Serializable id);
}