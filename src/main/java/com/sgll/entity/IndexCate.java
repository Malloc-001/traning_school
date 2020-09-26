package com.sgll.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 硕果累累
 * @since 2020-09-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class IndexCate implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String path;

    private String title;

    private Integer flag;


}
