package com.sgll.service;

import com.sgll.entity.IndexCate;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 硕果累累
 * @since 2020-09-22
 */
public interface IndexCateService extends IService<IndexCate> {

    List<IndexCate> getIndexSwipers();

    List<IndexCate> getIndexSchs();
}
