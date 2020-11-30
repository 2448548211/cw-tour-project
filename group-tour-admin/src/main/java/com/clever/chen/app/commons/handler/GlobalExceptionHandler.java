package com.clever.chen.app.commons.handler;



import com.clever.chen.app.commons.exception.BaseException;
import com.clever.chen.app.commons.exception.ServerException;
import com.clever.chen.app.commons.exception.ClientException;
import com.clever.chen.app.commons.result.BaseResult;
import com.clever.chen.app.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * 要求异常要记录在日志中--数据库中的日志表
 * @author ChenWang
 * @date 2020/11/09 11:14
 * @since JDK 1.8
 */
@RestControllerAdvice
@Slf4j
@Component
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     * @param ex    传入的异常
     * @return      返回给前端的数据包
     */
    @ExceptionHandler(Exception.class)
    public BaseResult<Object> handlerException(Exception ex){
        log.error("错误信息为:{}",ex.getMessage());
        log.error("错误类型为:{}",ex.getClass());
        return BaseResult.error(StatusCode.ERROR);
    }

    /**
     * ServiceException异常处理
     * @param ex    ServiceException异常
     * @return      指定的异常数据包
     * @author ChenWang
     * @date 2020/11/07 16:01
     */
    @ExceptionHandler(ServerException.class)
    public BaseResult<Object> handlerServiceException(ServerException ex){
        return BaseResult.error(ex);
    }
    /**
     * UserException异常处理
     * @param ex    UserException异常
     * @return      指定的异常数据包
     * @author ChenWang
     * @date 2020/11/07 16:02
     */
    @ExceptionHandler(ClientException.class)
    public BaseResult<Object> handlerUserException(ClientException ex){
        return BaseResult.error(ex);
    }

    /**
     * 通用型自定义异常处理
     * @param ex    自定义异常类型
     * @return      指定的异常数据包
     */
    public BaseResult<Object> handlerBaseException(BaseException ex){
        return BaseResult.error(ex);
    }
    /**
     * 数据校验---基于spring校验包的校验机制
     * @param ex    UserException异常
     * @return      指定的异常数据包
     * @author ChenWang
     * @date 2020/11/07 16:02
     */
    @ExceptionHandler(BindException.class)
    public BaseResult<Object> handlerBindException(BindException ex){
        /*获取所有的错误属性*/
        List<FieldError> allErrors = ex.getFieldErrors();
        StringBuilder sb = new StringBuilder();
        for (FieldError errorMessage : allErrors) {
            sb.append(errorMessage.getField()).append(": ").append(errorMessage.getDefaultMessage()).append(", ");
        }
        return BaseResult.error(StatusCode.PARAM_IS_DEFICIENCY,sb.toString());
    }
    /**
     * 参数异常是这个MethodArgumentNotValidException
     * @param ex   指定的异常类型
     * @return      根据异常类型返回指定的数据
     * @author ChenWang
     * @date 2020/11/08 14:28
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResult<Object> handlerBindException(MethodArgumentNotValidException ex){
        /*返回校验失败的注解上的message*/
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        return BaseResult.error(StatusCode.PARAM_IS_DEFICIENCY,fieldErrors);
    }
    /*传到前端的数据结构
    {
            "status": 40001,
            "msg": "user fomat error",
            "tip": "用户数据格式错误",
            "data": [
                        {
                            "codes": [
                                "NotNull.userRequestParam.password",
                                "NotNull.password",
                                "NotNull.java.lang.String",
                                "NotNull"
                            ],
                            "arguments": [
                                {
                                    "codes": [
                                        "userRequestParam.password",
                                        "password"
                                    ],
                                    "arguments": null,
                                    "defaultMessage": "password",
                                    "code": "password"
                                }
                            ],
                            "defaultMessage": "password不能为空",
                            "objectName": "userRequestParam",
                            "field": "password",
                            "rejectedValue": null,
                            "bindingFailure": false,
                            "code": "NotNull"
                        }
                    ]
        }*/


}
