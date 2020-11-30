package com.clever.chen.app.commons.response;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ChenWang
 * @date 2020/11/28 10:34
 * @since JDK 1.8
 */
@Data
public class ListPage<T> {
    /**
     * 查询数据列表
     */
    protected List<T> records;

    /**
     * 总数
     */
    protected long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    protected long size = 16;

    /**
     * 当前页
     */
    protected long current = 1;

    /**
     * 指定状态的产品数量的数组
     * 索引分别对应的状态
     * 0 上架
     * 1 下架
     * 2 草稿箱
     * 3 回收站
     */
    protected int[] counts;
}
