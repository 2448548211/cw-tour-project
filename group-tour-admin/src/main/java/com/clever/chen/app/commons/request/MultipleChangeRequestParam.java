package com.clever.chen.app.commons.request;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author ChenWang
 * @date 2020/11/27 19:28
 * @since JDK 1.8
 */
@Data
public class MultipleChangeRequestParam {
    /**
     * 修改的属性值
     */
    @NotNull(message = "需要设立状态值")
    @Min(value = 0,message = "设立的状态值过小")
    @Max(value = 3,message = "设立的状态值过大")
    private int status;
    /**
     * 需要修改状态的产品ID集合
     */
    @NotEmpty(message = "需要至少传入一个id")
    private List<Long> ids;
}
