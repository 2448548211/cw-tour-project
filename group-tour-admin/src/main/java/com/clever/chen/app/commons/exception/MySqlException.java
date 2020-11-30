package com.clever.chen.app.commons.exception;


import com.clever.chen.app.utils.StatusCode;

/**
 * 数据库的异常
 * @author ChenWang
 * @className DatabaseException
 * @date 2020/11/10 17:41
 * @since JDK 1.8
 */
public class MySqlException extends BaseException{
    public MySqlException(String message, int status, String msg, String tip) {
        super(message, status, msg, tip);
    }
    public MySqlException(StatusCode statusCode) {
        super(statusCode);
    }
}
