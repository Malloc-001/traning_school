package com.sgll.service.impl;

import com.sgll.entity.SyUser;
import com.sgll.mapper.SyUserMapper;
import com.sgll.service.SyUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 硕果累累
 * @since 2020-09-21
 */
@Service
public class SyUserServiceImpl extends ServiceImpl<SyUserMapper, SyUser> implements SyUserService {

    @Autowired
    private SyUserMapper userMapper;


    @Override
    public SyUser getUserInfo(String username, String password) {
        return userMapper.getUserInfo(username,password);
    }

}
