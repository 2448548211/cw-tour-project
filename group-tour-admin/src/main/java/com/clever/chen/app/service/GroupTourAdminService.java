package com.clever.chen.app.service;

import com.clever.chen.app.commons.request.ConditionalQueryRequestParam;
import com.clever.chen.app.commons.request.MultipleChangeRequestParam;
import com.clever.chen.app.commons.response.ListPage;
import com.clever.chen.app.commons.vo.ProductVo;

import java.util.List;

/**
 * @author ChenWang
 * @interfaceName GroupTourAdminService
 * @date 2020/11/27 14:46
 * @since JDK 1.8
 */
public interface GroupTourAdminService {
    List<ProductVo> selectList(int page, int size);

    boolean multipleChangeStatusByIds(MultipleChangeRequestParam multipleChangeRequestParam);

    ListPage<ProductVo> selectTheList(ConditionalQueryRequestParam conditionalQueryRequestParam, int page, int size);
}
