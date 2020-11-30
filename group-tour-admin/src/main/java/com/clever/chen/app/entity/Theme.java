package com.clever.chen.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
    * 类型表
    */
@Data
@TableName(value = "theme")
public class Theme {
    /**
     * 类型ID
     */
    @TableId(value = "theme_id", type = IdType.INPUT)
    private Long themeId;

    /**
     * 类型名字
     */
    @TableField(value = "theme_name")
    private String themeName;

    /**
     * 0表示存在1表示删除
     */
    @TableField(value = "is_del")
    private Integer isDel;

    public static final String COL_THEME_ID = "theme_id";

    public static final String COL_THEME_NAME = "theme_name";

    public static final String COL_IS_DEL = "is_del";
}