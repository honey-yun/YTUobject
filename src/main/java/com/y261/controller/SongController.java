package com.y261.controller;

import com.y261.entity.Song;
import com.y261.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 歌曲 前端控制器
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService songService;

    /**
     * 查询所有歌曲
     */
    @GetMapping("/all")
    public List<Song> all() {
        return songService.list();
    }

    /**
     * 根据主键查询
     */
    @GetMapping("/detail")
    public Song detail(@RequestParam Integer id) {
        return songService.getById(id);
    }

    /**
     * 根据歌曲名模糊查询
     */
    @GetMapping("/name")
    public List<Song> byName(@RequestParam(required = false) String name) {
        return songService.selectByName(name);
    }

    /**
     * 根据歌手ID查询
     */
    @GetMapping("/singer")
    public List<Song> bySinger(@RequestParam Integer singerId) {
        return songService.selectBySingerId(singerId);
    }

    /**
     * 根据歌单ID查询
     */
    @GetMapping("/song-list")
    public List<Song> bySongList(@RequestParam Integer songListId) {
        return songService.selectBySongListId(songListId);
    }

    /**
     * 新增歌曲
     */
    @PostMapping("/add")
    public boolean add(@RequestBody Song song) {
        return songService.addSong(song);
    }

    /**
     * 更新歌曲
     */
    @PostMapping("/update")
    public boolean update(@RequestBody Song song) {
        return songService.updateSong(song);
    }

    /**
     * 根据主键删除歌曲
     */
    @PostMapping("/delete")
    public boolean delete(@RequestParam Integer id) {
        return songService.deleteSong(id);
    }
}