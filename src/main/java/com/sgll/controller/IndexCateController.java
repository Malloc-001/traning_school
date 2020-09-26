package com.sgll.controller;


import com.sgll.entity.IndexCate;
import com.sgll.service.IndexCateService;
import com.sgll.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 硕果累累
 * @since 2020-09-22
 */
@RestController
@RequestMapping("/index")
public class IndexCateController {

    @Autowired
    private IndexCateService indexService;

    @GetMapping("getSwipers")
    public R getSwipers(){
        List<IndexCate> indexSwipers = indexService.getIndexSwipers();
        return R.ok().data("swipers",indexSwipers);
    }

    @GetMapping("getSchs")
    public R getSchs(){
        List<IndexCate> indexSchs = indexService.getIndexSchs();
        return R.ok().data("schs",indexSchs);
    }

    @PostMapping("/add")
    public R addSwiper(@RequestBody IndexCate indexCate){
        if (indexService.save(indexCate)) {
            return R.ok().message("轮播图新增成功");
        }
        return R.error().message("轮播图新增失败");
    }

    @GetMapping("/delete/{id}")
    public R deleteSwiper(@PathVariable Integer id){
        if (indexService.removeById(id)) {
            return R.ok().message("删除轮播图成功");
        }
        return R.error().message("删除轮播图失败");
    }

    @PostMapping("/update")
    public R deleteSwiper(@RequestBody IndexCate indexCate){
        if (indexService.updateById(indexCate)) {
            return R.ok().message("更新轮播图成功");
        }
        return R.error().message("更新轮播图失败");
    }

}

