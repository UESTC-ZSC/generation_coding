package com.monsters.common.web;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果
 *
 * @author Monsters
 * @date 2022/9/9 9:06 PM
 */
@Data
public class ResultData<T> implements Serializable {

    private long code;

    private String message = "";

    private T data;

    public ResultData() {
    }

    public ResultData(T result) {
        this(BusinessExceptionEnum.SUCCESS.getCode(), BusinessExceptionEnum.SUCCESS.getMessage(), result);
    }


    public ResultData(long code, String message) {
        this.code = code;
        this.message = message;
    }

    protected ResultData(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 返回成功结果
     */
    public static ResultData getSuccessResult() {
        return new ResultData(BusinessExceptionEnum.SUCCESS.getCode(), BusinessExceptionEnum.SUCCESS.getMessage());
    }

    /**
     * 返回成功结果
     *
     * @param message
     */
    public static ResultData getSuccessResult(String message) {
        return new ResultData(BusinessExceptionEnum.SUCCESS.getCode(), message);
    }

    /**
     * 返回成功结果
     *
     * @param code
     * @param message
     */
    public static ResultData getSuccessResult(long code, String message) {
        return new ResultData(code, message);
    }

    /**
     * 返回成功结果
     *
     * @param data
     * @param <T>
     */
    public static <T> ResultData<T> getSuccessData(T data) {
        return new ResultData<T>(data);
    }

    /**
     * 返回成功结果
     *
     * @param data
     * @param message
     * @param <T>
     */
    public static <T> ResultData<T> getSuccessData(T data, String message) {
        return new ResultData<T>(BusinessExceptionEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 返回失败结果
     */
    public static ResultData getFailResult() {
        return new ResultData(BusinessExceptionEnum.FAILED.getCode(), BusinessExceptionEnum.FAILED.getMessage());
    }

    /**
     * 返回失败结果
     *
     * @param message
     */
    public static ResultData getFailResult(String message) {
        return new ResultData(BusinessExceptionEnum.FAILED.getCode(), message);
    }

    /**
     * 返回失败结果
     *
     * @param code
     * @param message
     */
    public static ResultData getFailResult(long code, String message) {
        return new ResultData(code, message);
    }

    /**
     * 参数校验失败返回结果
     *
     * @param message
     */
    public static ResultData validateFailed(String message) {
        return new ResultData(BusinessExceptionEnum.VALIDATE_FAILED.getCode(), message);
    }

    /**
     * 未登录返回结果
     *
     * @param data
     * @param <T>
     */
    public static <T> ResultData<T> unauthorized(T data) {
        return new ResultData<T>(BusinessExceptionEnum.UNAUTHORIZED.getCode(), BusinessExceptionEnum.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 权限不足返回结果
     *
     * @param data
     * @param <T>
     */
    public static <T> ResultData<T> forbidden(T data) {
        return new ResultData<T>(BusinessExceptionEnum.FORBIDDEN.getCode(), BusinessExceptionEnum.FORBIDDEN.getMessage(), data);
    }
}
