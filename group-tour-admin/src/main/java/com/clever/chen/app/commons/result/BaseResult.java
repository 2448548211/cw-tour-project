package com.clever.chen.app.commons.result;

import com.clever.chen.app.commons.exception.BaseException;
import com.clever.chen.app.utils.StatusCode;
import lombok.Builder;
import lombok.Data;

/**
 * @author ChenWang
 * @date 2020/11/27 14:31
 * @since JDK 1.8
 */
@Builder
@Data
public class BaseResult<T> {
    /**
     * 状态码
     */
    private int status;
    /**
     * 英文提示信息
     */
    private String msg;
    /**
     * 中文提示信息
     */
    private String tip;
    /**
     * 可能存在的实际传送的数据包
     */
    private T data;

    /**
     * 成功之后的基本数据包
     * @param statusCode    指定的状态类
     * @param data          指定的实际数据
     * @param <E>           指定的实际数据的类型
     * @return              传给前端的基本数据包
     */
    public static<E> BaseResult<E> success(StatusCode statusCode, E data){
        return (BaseResult<E>) BaseResult
                .builder()
                .data(data)
                .msg(statusCode.getMsg())
                .status(statusCode.getStatus())
                .tip(statusCode.getTip())
                .build();
    }
    /**
     * 成功之后的默认的基本数据包
     * @param data          指定的实际数据
     * @param <E>           指定的实际数据的类型
     * @return              传给前端的基本数据包
     */
    public static<E> BaseResult<E> success(E data){
        return success(StatusCode.SUCCESS, data);
    }
    /**
     * 错误之后的基本数据包
     * @param statusCode    指定的状态类
     * @param <E>           指定的实际数据的类型
     * @return              传给前端的基本数据包
     */
    public static<E> BaseResult<E> error(StatusCode statusCode){
        return error(statusCode,null);
    }
    /**
     * 错误之后的基本数据包
     * @param statusCode    指定的状态类
     * @param data          指定的实际数据
     * @param <E>           指定的实际数据的类型
     * @return              传给前端的基本数据包
     */
    public static<E> BaseResult<E> error(StatusCode statusCode, E data){
        return (BaseResult<E>) BaseResult
                .builder()
                .data(data)
                .msg(statusCode.getMsg())
                .status(statusCode.getStatus())
                .tip(statusCode.getTip())
                .build();
    }
    /**
     * 错误之后的基本数据包--默认
     * @param <E>           指定的实际数据的类型
     * @return              传给前端的基本数据包
     */
    public static<E> BaseResult<E> error(){
        return error(StatusCode.ERROR);
    }
    /**
     * 用于全局异常,通过异常参数生成对应的错误信息响应包
     * @param status    指定的状态码
     * @param msg       指定的状态信息 英文
     * @param tip       指定的状态信息 中文
     * @return          错误信息响应包
     * @date 2020/11/06 15:35
     */
    public static<E> BaseResult<E> error(int status, String msg, String tip){
        return (BaseResult<E>) BaseResult
                .builder()
                .msg(msg)
                .status(status)
                .tip(tip)
                .build();
    }
    /**
     * 根据异常类型传送给前端的基本数据包
     * @param ex            指定的异常类型
     * @param <E>           指定的实际数据的类型
     * @return              传给前端的基本数据包
     */
    public static<E> BaseResult<E> error(BaseException ex){
        return error(ex,null);
    }
    /**
     * 根据异常类型传送给前端的基本数据包
     * @param ex            指定的异常类型
     * @param <E>           指定的实际数据的类型
     * @param data          指定的传输数据
     * @return              传给前端的基本数据包
     */
    public static<E> BaseResult<E> error(BaseException ex, E data){
        return (BaseResult<E>) BaseResult
                .builder()
                .data(data)
                .msg(ex.getMsg())
                .status(ex.getStatus())
                .tip(ex.getTip())
                .build();
    }
}
