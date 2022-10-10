package com.monsters.generationcodingadmin.common.web;

/**
 * @author Monsters
 * @date 2022/9/9 9:00 PM
 */
public enum BusinessExceptionEnum implements IErrorCode{
    SUCCESS(0000, "请求成功"),
    FAILED(0005, "操作失败"),
    UNKNOWN_EXCEPTION(9999, "系统未知错误"),
    VALIDATE_FAILED(0001, "参数检验失败"),
    UNAUTHORIZED(0002, "暂未登录或token已经过期"),
    FORBIDDEN(0003, "没有相关权限");

    private long code;

    private String msg;


    private BusinessExceptionEnum(long code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    @Override
    public long getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return msg;
    }
}
