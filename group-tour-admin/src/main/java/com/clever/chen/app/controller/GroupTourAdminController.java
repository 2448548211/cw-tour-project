package com.clever.chen.app.controller;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.clever.chen.app.commons.exception.MyTransactionException;
import com.clever.chen.app.commons.exception.ServerException;
import com.clever.chen.app.commons.request.ConditionalQueryRequestParam;
import com.clever.chen.app.commons.request.MultipleChangeRequestParam;
import com.clever.chen.app.commons.response.ListPage;
import com.clever.chen.app.commons.result.BaseResult;
import com.clever.chen.app.commons.vo.ProductVo;
import com.clever.chen.app.service.GroupTourAdminService;
import com.clever.chen.app.utils.StatusCode;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author ChenWang
 * @date 2020/11/27 14:45
 * @since JDK 1.8
 */
@RestController
@RequestMapping("/grouplist")
@DS("salve-read-3327")
public class GroupTourAdminController {

    @Resource
    GroupTourAdminService groupTourAdminService;

    /**
     * 展示无限制的分页数据
     * @return  分页数据的封装包
     */
    @Deprecated
    @GetMapping("/list")
    public BaseResult<List<ProductVo>> list(
            @RequestParam(required = false,defaultValue = "1")int page,
            @RequestParam(required = false,defaultValue = "16")int size
    ){
        List<ProductVo> productVos = groupTourAdminService.selectList(page, size);
        if(Objects.isNull(productVos)||productVos.size()==0){
            /* 基本数据都没搜到 -- */
            throw new ServerException(StatusCode.BUSINESS_UNKNOW_ERROR);
        }
        return BaseResult.success(productVos);
    }

    /**
     * 查询指定状态的页面信息
     * @param page      指定的页码
     * @param size      指定的大小
     * @param conditionalQueryRequestParam  条件封装类
     * @return          结果集封装类
     */
    @PostMapping("/thelist")
    public BaseResult<ListPage<ProductVo>> theList(
            @RequestHeader(value = "page" ,required = false,defaultValue = "1") int page,
            @RequestHeader(value = "size" ,required = false,defaultValue = "16") int size,
            @RequestBody ConditionalQueryRequestParam conditionalQueryRequestParam){
        ListPage<ProductVo> listPage = groupTourAdminService.selectTheList(conditionalQueryRequestParam, page , size );
        if(Objects.isNull(listPage)){
            throw new ServerException(StatusCode.BUSINESS_UNKNOW_ERROR);
        }
        return BaseResult.success(listPage);
    }
    /**
     * 多选产品的状态值修改
     * @param multipleChangeRequestParam    指定参数的封装类
     * @return                              数据封装类
     */
    @DS("master")
    @Transactional(rollbackFor = MyTransactionException.class)
    @PostMapping("/changeStatus")
    public BaseResult<Boolean> multipleChangeStatus(@RequestBody @Validated MultipleChangeRequestParam multipleChangeRequestParam){
        boolean flag = groupTourAdminService.multipleChangeStatusByIds(multipleChangeRequestParam);
        return BaseResult.success(flag);

    }
}
