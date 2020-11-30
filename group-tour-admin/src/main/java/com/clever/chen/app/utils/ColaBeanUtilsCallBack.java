package com.clever.chen.app.utils;

/**
 * @author ChenWang
 * @interfaceName ColaBeanUtilsCallBack
 * @date 2020/11/09 15:37
 * @since JDK 1.8
 */
@FunctionalInterface
public interface ColaBeanUtilsCallBack<S,T> {
    void callBack(S t, T s);
}
