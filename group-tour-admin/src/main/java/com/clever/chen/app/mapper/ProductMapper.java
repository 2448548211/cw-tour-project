package com.clever.chen.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.clever.chen.app.commons.request.ConditionalQueryRequestParam;
import com.clever.chen.app.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper extends BaseMapper<Product> {
    /**
     * 分页查询指定条件（包括状态）的产品的信息
     * @param condition     指定的条件
     * @param offset        偏移量
     * @param size          指定的大小
     * @return              返回的产品的数量集合
     */
    List<Product> selectTheList(@Param("condition")ConditionalQueryRequestParam condition,@Param("offset") int offset,@Param("size")  int size);

    /**
     * 查询限定条件下的所有的产品的数量
     * @param condition     指定的条件
     * @return              返回计算的数据
     */
    int selectTotalCountByCondition(@Param("condition")ConditionalQueryRequestParam condition);
    /**
     * 查询限定条件下的指定状态的产品的数量
     * 状态：
     * 0表示上架中,
     * 1表示在仓库（下架）,
     * 2表示在草稿箱,
     * 3表示放入回收站（待下架）
     * @param condition     指定的条件
     * @return              返回计算的数据
     */
    int selectCountByCondition(@Param("condition")ConditionalQueryRequestParam condition);
}