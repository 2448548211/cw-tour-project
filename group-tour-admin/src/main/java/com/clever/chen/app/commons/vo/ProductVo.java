package com.clever.chen.app.commons.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
    * 产品表
    */
@Data
public class ProductVo {
    /**
     * 产品ID
     */
    private Long productId;

    /**
     * 主标题
     */
    private String head;

    /**
     * 副标题
     */
    private String subhead;

    /**
     * 出发地
     */
    private String start;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 团建基地
     */
    private String base;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 负责人ID
     */
    private Long managerId;

    /**
     * 负责人名字
     */
    private String managerName;

    /**
     * 点击数
     */
    private Long click;

    /**
     * 状态：0表示上架中,1表示在仓库（下架）,2表示在草稿箱,3表示放入回收站（待下架）
     */
    private Integer status;

    /**
     * 类型ID
     */
    private Integer typeId;

    /**
     * 类型名字
     */
    private String typeName;

    /**
     * 0表示新品,1表示热门,2表示推荐
     */
    private Integer orderMark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 过期时间
     */
    private Date expirationTime;


}