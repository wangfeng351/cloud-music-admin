package com.soft1851.cloud.music.admin.mapper;

import com.soft1851.cloud.music.admin.domain.entity.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wf
 * @since 2020-04-21
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * 获取所有菜单资源
     * @return
     */
    List<Map<String, Object>> selectAll();

    /**
     * 获取子类资源
     * @return
     */
    List<Map<String, Object>> getChildMenu();
}
