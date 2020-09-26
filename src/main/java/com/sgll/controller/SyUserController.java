package com.sgll.controller;


import com.sgll.entity.SyUser;
import com.sgll.service.SyUserService;
import com.sgll.utils.JWTUtils;
import com.sgll.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 硕果累累
 * @since 2020-09-21
 */
@CrossOrigin
@RestController
@RequestMapping("/user")
public class SyUserController {

    @Autowired
    private SyUserService userService;

    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public R login(@RequestBody SyUser sysUser){
        SyUser sysUserDB = userService.getUserInfo(sysUser.getUsername(),sysUser.getPassword());
        if(sysUserDB != null){
            Map<String,String> payload = new HashMap<>();
            payload.put("id",sysUserDB.getId().toString());
            payload.put("name",sysUserDB.getUsername());
            // 生成 jWt 令牌
            String token = JWTUtils.getToken(payload);
            System.out.println("============================="+token);
            // 响应token
            return R.ok().data("token",token).message("登录成功！");
        }
        return R.error().message("登录失败！");
    }

    @GetMapping("/list")
    public R getUser(){
        List<SyUser> users = userService.list();
        return R.ok().data("users",users);
    }

    @GetMapping("/{id}")
    public R getUserById(@PathVariable Integer id){
        SyUser user = userService.getById(id);
        return R.ok().data("usersInfo",user);
    }

    @PostMapping("/add")
    public R addUser(@RequestBody SyUser userVo){
//        userVo.setPassword(passwordEncoder.encode(userVo.getPassword()));
        boolean save = userService.save(userVo);
        if(save){
            return R.ok().message("添加用户成功！");
        }else {
            return R.error().message("添加用户失败！");
        }
    }

    @GetMapping("/delete/{id}")
    public R deleteUser(@PathVariable Integer id){
        if (userService.removeById(id)) {
            return R.ok().message("删除用户成功");
        }
        return R.error().message("删除用户失败");
    }

    @PostMapping("/update")
    public R updateUser(@RequestBody SyUser user){
        if (userService.updateById(user)) {
            return R.ok().message("更新用户成功");
        }
        return R.error().message("更新用户失败");
    }

}

