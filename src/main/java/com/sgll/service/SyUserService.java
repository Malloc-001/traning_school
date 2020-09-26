package com.sgll.service;

import com.sgll.entity.SyUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 硕果累累
 * @since 2020-09-21
 */
public interface SyUserService extends IService<SyUser> {

    /**
     * 查找是否有该用户
     * @param username 用户名
     * @param password 密码
     * @return
     */
    SyUser getUserInfo(String username, String password);
}
