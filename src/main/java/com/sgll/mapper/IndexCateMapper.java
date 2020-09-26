package com.sgll.mapper;

import com.sgll.entity.IndexCate;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 硕果累累
 * @since 2020-09-22
 */
@Repository
public interface IndexCateMapper extends BaseMapper<IndexCate> {

    @Select("SELECT * from index_cate WHERE flag = 3")
    List<IndexCate> getIndexSwipers();

    @Select("SELECT * from index_cate WHERE flag = 2")
    List<IndexCate> getIndexSchs();
}
