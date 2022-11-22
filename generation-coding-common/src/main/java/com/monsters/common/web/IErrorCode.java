package com.monsters.common.web;

/**
 * 封装 api 错误代码
 * @author Monsters
 * @date 2022/9/9 8:56 PM
 */

public interface IErrorCode {
    long getCode();

    String getMessage();
}
