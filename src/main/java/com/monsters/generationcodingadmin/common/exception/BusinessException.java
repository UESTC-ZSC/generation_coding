package com.monsters.generationcodingadmin.common.exception;

import com.monsters.generationcodingadmin.common.web.IErrorCode;

/**
 * 自定义API异常
 * @author Monsters
 * @date 2022/9/9 8:39 PM
 */

public class BusinessException extends RuntimeException {
    private IErrorCode errorCode;

    public BusinessException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
