package com.clever.chen.app.commons.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
    * 类型表
    */
@Data
public class Theme {
    /**
     * 类型ID
     */
    private Long themeId;

    /**
     * 类型名字
     */
    private String themeName;

    /**
     * 0表示存在1表示删除
     */
    private Integer isDel;

}