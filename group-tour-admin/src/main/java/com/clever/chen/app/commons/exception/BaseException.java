package com.clever.chen.app.commons.exception;

import com.clever.chen.app.utils.StatusCode;
import lombok.Data;

/**
 * @author ChenWang
 * @className BaseException
 * @date 2020/11/27 14:31
 * @since JDK 1.8
 */
@Data
public class BaseException extends RuntimeException{
    private int status;
    private String msg;
    private String tip;

    /**
     * 全参构造方法
     * @param message   指定的信息
     * @param status    指定的状态码
     * @param msg       指定的英文信息
     * @param tip       指定的中文信息
     */
    public BaseException(String message, int status, String msg, String tip) {
        super(message);
        this.status = status;
        this.msg = msg;
        this.tip = tip;
    }

    /**
     * 根据传入的状态类生成指定的异常
     * @param statusCode    传入的状态类
     */
    public BaseException(StatusCode statusCode) {
        this.status = statusCode.getStatus();
        this.msg = statusCode.getMsg();
        this.tip = statusCode.getTip();
    }
}
