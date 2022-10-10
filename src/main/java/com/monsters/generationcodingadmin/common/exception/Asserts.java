package com.monsters.generationcodingadmin.common.exception;

import com.monsters.generationcodingadmin.common.web.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 * @author Monsters
 * @date 2022/9/9 9:04 PM
 */
public class Asserts {
    public static void fail(String message) {
        throw new BusinessException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new BusinessException(errorCode);
    }
}
