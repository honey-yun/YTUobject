package com.y261.service.impl;

import com.y261.entity.ListSong;
import com.y261.dao.ListSongMapper;
import com.y261.service.IListSongService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 歌单包含歌曲列表 服务实现类
 * </p>
 *
 * @author honey-yun
 * @since 2026-09-01
 */
@Service
public class ListSongServiceImpl extends ServiceImpl<ListSongMapper, ListSong> implements IListSongService {

}
