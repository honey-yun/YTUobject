package com.y261.service;

import com.y261.entity.Song;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 歌曲 服务类
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
public interface ISongService extends IService<Song> {

    /**
     * 根据歌曲名模糊查询
     */
    List<Song> selectByName(String name);

    /**
     * 根据歌手ID查询
     */
    List<Song> selectBySingerId(Integer singerId);

    /**
     * 根据歌单ID查询
     */
    List<Song> selectBySongListId(Integer songListId);

    /**
     * 新增歌曲
     */
    boolean addSong(Song song);

    /**
     * 根据主键更新歌曲
     */
    boolean updateSong(Song song);

    /**
     * 根据主键删除歌曲
     */
    boolean deleteSong(Integer id);
}