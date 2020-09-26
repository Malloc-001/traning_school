package com.sgll.service.impl;

import com.sgll.entity.IndexCate;
import com.sgll.mapper.IndexCateMapper;
import com.sgll.service.IndexCateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 硕果累累
 * @since 2020-09-22
 */
@Service
public class IndexCateServiceImpl extends ServiceImpl<IndexCateMapper, IndexCate> implements IndexCateService {

    @Autowired
    private IndexCateMapper indexCateMapper;

    @Override
    public List<IndexCate> getIndexSwipers() {
        return indexCateMapper.getIndexSwipers();
    }

    @Override
    public List<IndexCate> getIndexSchs() {
        return indexCateMapper.getIndexSchs();
    }
}
