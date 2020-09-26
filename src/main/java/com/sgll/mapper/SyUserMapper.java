package com.sgll.mapper;

import com.sgll.entity.SyUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 硕果累累
 * @since 2020-09-21
 */
@Repository
public interface SyUserMapper extends BaseMapper<SyUser> {

//    @Select("select password from sy_user where username = #{username}")
//    String getPassword(String username);

    @Select("select * from sy_user " +
            "where username = #{username} and password = #{password}")
    SyUser getUserInfo(String username, String password);
}
