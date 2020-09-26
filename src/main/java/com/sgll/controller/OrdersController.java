package com.sgll.controller;


import com.sgll.entity.Orders;
import com.sgll.mapper.OrdersMapper;
import com.sgll.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  预约咨询-- 前端控制器
 * </p>
 *
 * @author Malloc
 * @since 2020-09-24
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersMapper ordersMapper;

    @PostMapping("/add")
    public R addOrder(@RequestBody Orders orderVo){
        int insert = ordersMapper.insert(orderVo);
        if (insert > 0){
            return R.ok().message("预约成功！");
        }else {
            return R.error().message("预约失败！");
        }
    }

}

