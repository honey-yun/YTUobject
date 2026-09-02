package com.y261.service.impl;

import com.y261.entity.Song;
import com.y261.dao.SongMapper;
import com.y261.service.ISongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 歌曲 服务实现类
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements ISongService {

    @Override
    public List<Song> selectByName(String name) {
        return baseMapper.selectByName(name);
    }

    @Override
    public List<Song> selectBySingerId(Integer singerId) {
        return baseMapper.selectBySingerId(singerId);
    }

    @Override
    public List<Song> selectBySongListId(Integer songListId) {
        return baseMapper.selectBySongListId(songListId);
    }

    @Override
    public boolean addSong(Song song) {
        if (song == null) {
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        if (song.getCreateTime() == null) {
            song.setCreateTime(now);
        }
        song.setUpdateTime(now);
        return save(song);
    }

    @Override
    public boolean updateSong(Song song) {
        if (song == null || song.getId() == null) {
            return false;
        }
        song.setUpdateTime(LocalDateTime.now());
        return updateById(song);
    }

    @Override
    public boolean deleteSong(Integer id) {
        if (id == null) {
            return false;
        }
        return removeById(id);
    }
}