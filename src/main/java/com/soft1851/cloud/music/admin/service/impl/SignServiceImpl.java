package com.soft1851.cloud.music.admin.service.impl;

import cn.hutool.crypto.asymmetric.Sign;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.soft1851.cloud.music.admin.common.ResultCode;
import com.soft1851.cloud.music.admin.domain.entity.RoleMenu;
import com.soft1851.cloud.music.admin.domain.entity.SignIn;
import com.soft1851.cloud.music.admin.exception.CustomException;
import com.soft1851.cloud.music.admin.mapper.RoleMenuMapper;
import com.soft1851.cloud.music.admin.mapper.SignMapper;
import com.soft1851.cloud.music.admin.service.SignService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/5/4
 * @Version 1.0
 */
@Service
public class SignServiceImpl extends ServiceImpl<SignMapper, SignIn> implements SignService {
    @Resource
    private SignMapper signMapper;

    @Override
    public List<Map<String, Object>> selectAll() {
        return signMapper.selectAll();
    }

    @Override
    public void update(SignIn signIn) {
        Map<String, Object> map = signMapper.getByAdminId(signIn.getAdminId());
        SignIn signIn1 = SignIn.builder().id(Integer.parseInt(map.get("id").toString()))
                .status(1).build();
        try {
            signMapper.updateById(signIn1);
        }catch (Exception e){
            throw new CustomException("用户数据新增异常", ResultCode.DATABASE_ERROR);
        }
    }
}
