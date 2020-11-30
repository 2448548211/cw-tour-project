package com.clever.chen.app.commons.exception;


import com.clever.chen.app.utils.StatusCode;

/**
 * @author ChenWang
 * @className UserException
 * @date 2020/11/09 15:06
 * @since JDK 1.8
 */
public class ClientException extends BaseException {


    public ClientException(String message, int status, String msg, String tip) {
        super(message, status, msg, tip);
    }

    public ClientException(StatusCode statusCode) {
        super(statusCode);
    }

}
