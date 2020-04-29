package com.soft1851.cloud.music.admin.controller;


import com.soft1851.cloud.music.admin.common.ResponseResult;
import com.soft1851.cloud.music.admin.domain.entity.Song;
import com.soft1851.cloud.music.admin.service.SongService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wf
 * @since 2020-04-21
 */
@RestController
@RequestMapping(value = "/song")
@Slf4j
public class SongController {
    @Resource
    private SongService songService;

    @GetMapping("/list")
    public List<Song> selectAll() {
        return songService.selectAll();
    }

    @GetMapping("/blur")
    public List<Song> getSongBy(@Param("field") String field) {
        return songService.getSongBy(field);
    }

    @GetMapping("/paragraph")
    public List<Song> getSongByTime(@Param("flag") String flag) {
        log.info(flag);
        return songService.getSongByDate(flag);
    }

    @DeleteMapping("/many")
    public ResponseResult batchDelete(@Param("id") String id) {
        songService.batchDelete(id);
        return ResponseResult.success();
    }

    @DeleteMapping("/single/{id}")
    public ResponseResult singleDelete(@PathVariable String id) {
        songService.delete(id);
        return ResponseResult.success();
    }

    @GetMapping(value = "/export")
    public void exportData() {
        songService.exportData();
    }
}
