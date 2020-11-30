package com.clever.chen.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clever.chen.app.commons.exception.ClientException;
import com.clever.chen.app.commons.exception.ServerException;
import com.clever.chen.app.commons.request.ConditionalQueryRequestParam;
import com.clever.chen.app.commons.request.MultipleChangeRequestParam;
import com.clever.chen.app.commons.response.ListPage;
import com.clever.chen.app.commons.vo.ProductVo;
import com.clever.chen.app.entity.Product;
import com.clever.chen.app.mapper.ProductMapper;
import com.clever.chen.app.service.GroupTourAdminService;
import com.clever.chen.app.utils.MyBeanUtils;
import com.clever.chen.app.utils.StatusCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author ChenWang
 * @date 2020/11/27 14:46
 * @since JDK 1.8
 */
@Service
public class GroupTourAdmidServiceImpl implements GroupTourAdminService {
    @Resource
    ProductMapper productMapper;
    /**
     * 查询没有限制条件的产品数据
     * @param page  当前页码
     * @param size  页面大小
     * @return      指定的产品数据的VO集合
     */
    @Override
    public List<ProductVo> selectList(int page, int size) {
        Page<Product> productPage = productMapper.selectPage(new Page<>(page, size), new QueryWrapper<>());
        return MyBeanUtils.copyListProperties(productPage.getRecords(), ProductVo::new);
    }

    /**
     * 多选更改产品的状态值
     *  0 上架
     *  1 下架
     *  2 草稿箱
     *  3 回收站
     * @param multipleChangeRequestParam    指定的参数封装类，包含所有需要修改的产品id和将被修改的状态结果
     * @return                              true表示成功，false表示失败
     */
    @Override
    public boolean multipleChangeStatusByIds(MultipleChangeRequestParam multipleChangeRequestParam) {
        QueryWrapper<Product> qw = new QueryWrapper<>();
        List<Long> ids = multipleChangeRequestParam.getIds();
        ids.forEach((id)-> qw.lambda().or().eq(Product::getProductId,id));
        Product product = new Product();
        product.setStatus(multipleChangeRequestParam.getStatus());
        int update = productMapper.update(product, qw);
        /*
         * 哪怕数据一样也会有update_time的更新，所以数据必定更新
         */
        return update==ids.size();
    }

    /**
     * 按照传入的条件查询指定的旅游产品
     * @param conditionalQueryRequestParam  封装的条件类
     * @param page                          指定的页码
     * @param size                          指定的大小
     * @return                              产品的页面封装类
     */
    @Override
    public ListPage<ProductVo> selectTheList(ConditionalQueryRequestParam conditionalQueryRequestParam, int page, int size) {
        if(Objects.isNull(conditionalQueryRequestParam)){
            conditionalQueryRequestParam = new ConditionalQueryRequestParam();
        }
        ListPage<ProductVo> listPage = new ListPage<>();
        int total = productMapper.selectTotalCountByCondition(conditionalQueryRequestParam);
        if(0==total){
            throw new ServerException(StatusCode.SYSTEM_INNER_ERROR);
        }
        listPage.setTotal(total);
        int thePage = total%size==0?total/size:(total/size)+1;
        page = page<1? 1: Math.min(page, thePage);
        listPage.setSize(size);
        listPage.setCurrent(page);
        List<Product> products = productMapper.selectTheList(conditionalQueryRequestParam,(page-1)*size,size);
        List<ProductVo> productVos = MyBeanUtils.copyListProperties(products, ProductVo::new);
        listPage.setRecords(productVos);
        /*依次查询各种状态的符合条件的产品数量
        * 0 上架
        * 1 下架
        * 2 草稿箱
        * 3 回收站
        * */
        int[] counts = new int[4];
        for (int i = 0; i < 4; i++) {
            conditionalQueryRequestParam.setStatus(0);
            counts[i] = productMapper.selectCountByCondition(conditionalQueryRequestParam);
        }
        listPage.setCounts(counts);
        return listPage;
    }
}
