package com.clever.chen.app.commons.request;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author ChenWang
 * @date 2020/11/28 10:30
 * @since JDK 1.8
 */
@Data
public class ConditionalQueryRequestParam {

    /**
     * 出发地
     */
    private String start;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 状态：0表示上架中,1表示在仓库（下架）,2表示在草稿箱,3表示放入回收站（待下架）
     */
    private Integer status;

    /**
     * 类型ID
     */
    private Integer typeId;

    /**
     * 关键字
     */
    private String keyStr;
    /**
     * 主题ID
     */
    private List<Integer> themes;

}
