package com.clever.chen.app.commons.exception;


import com.clever.chen.app.utils.StatusCode;

/**
 * @author ChenWang
 * @className ServiceException
 * @date 2020/11/09 15:05
 * @since JDK 1.8
 */
public class ServerException extends BaseException {
    public ServerException(String message, int status, String msg, String tip) {
        super(message, status, msg, tip);
    }
    public ServerException(StatusCode statusCode) {
        super(statusCode);
    }
}
