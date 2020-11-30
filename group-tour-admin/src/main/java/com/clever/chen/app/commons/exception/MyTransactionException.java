package com.clever.chen.app.commons.exception;

import com.clever.chen.app.utils.StatusCode;

/**
 * @author ChenWang
 * @date 2020/11/27 19:42
 * @since JDK 1.8
 */
public class MyTransactionException extends BaseException {
    public MyTransactionException(String message, int status, String msg, String tip) {
        super(message, status, msg, tip);
    }
    public MyTransactionException(StatusCode statusCode) {
        super(statusCode);
    }
}
