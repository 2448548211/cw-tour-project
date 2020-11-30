package com.clever.chen.app.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 产品表
 */
@Data
@TableName(value = "product")
public class Product {
    /**
     * 产品ID
     */
    @TableId(value = "product_id", type = IdType.INPUT)
    private Long productId;

    /**
     * 主标题
     */
    @TableField(value = "head")
    private String head;

    /**
     * 副标题
     */
    @TableField(value = "subhead")
    private String subhead;

    /**
     * 出发地
     */
    @TableField(value = "`start`")
    private String start;

    /**
     * 目的地
     */
    @TableField(value = "destination")
    private String destination;

    /**
     * 团建基地
     */
    @TableField(value = "base")
    private String base;

    /**
     * 价格
     */
    @TableField(value = "price")
    private BigDecimal price;

    /**
     * 负责人ID
     */
    @TableField(value = "manager_id")
    private Long managerId;

    /**
     * 负责人名字
     */
    @TableField(value = "manager_name")
    private String managerName;

    /**
     * 点击数
     */
    @TableField(value = "click")
    private Long click;

    /**
     * 状态：0表示上架中,1表示在仓库（下架）,2表示在草稿箱,3表示放入回收站（待下架）
     */
    @TableField(value = "`status`")
    private Integer status;

    /**
     * 类型ID
     */
    @TableField(value = "type_id")
    private Integer typeId;

    /**
     * 类型名字
     */
    @TableField(value = "type_name")
    private String typeName;

    /**
     * 0表示新品,1表示热门,2表示推荐
     */
    @TableField(value = "order_mark")
    private Integer orderMark;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    /**
     * 过期时间
     */
    @TableField(value = "expiration_time")
    private Date expirationTime;

    /**
     * 0表示存在1表示删除
     */
    @TableField(value = "is_del")
    private Integer isDel;

    /**
     * 乐观锁 版本控制
     */
    @TableField(value = "version")
    @Version
    private Integer version;

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_HEAD = "head";

    public static final String COL_SUBHEAD = "subhead";

    public static final String COL_START = "start";

    public static final String COL_DESTINATION = "destination";

    public static final String COL_BASE = "base";

    public static final String COL_PRICE = "price";

    public static final String COL_MANAGER_ID = "manager_id";

    public static final String COL_MANAGER_NAME = "manager_name";

    public static final String COL_CLICK = "click";

    public static final String COL_STATUS = "status";

    public static final String COL_TYPE_ID = "type_id";

    public static final String COL_TYPE_NAME = "type_name";

    public static final String COL_ORDER_MARK = "order_mark";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_EXPIRATION_TIME = "expiration_time";

    public static final String COL_IS_DEL = "is_del";

    public static final String COL_VERSION = "version";
}