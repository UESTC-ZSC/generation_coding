package com.monsters.generationcodingadmin.common.exception;

import com.monsters.generationcodingadmin.common.web.ResultData;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 * @author Monsters
 * @date 2022/9/9 9:05 PM
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 业务异常处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BusinessException.class)
    public ResultData handle(BusinessException e){
        if (e.getErrorCode() != null){
            return ResultData.getFailResult(e.getErrorCode().getCode(), e.getErrorCode().getMessage());
        }
        return ResultData.getFailResult(e.getMessage());
    }


    /**
     * 参数校验错误异常处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResultData handleValidException(MethodArgumentNotValidException e) {
        return getResultData(e);
    }


    /**
     * 参数校验错误异常处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public ResultData handleValidException(BindException e) {
        return getResultData(e);
    }

    private ResultData getResultData(BindException e) {
        BindingResult bindingResult = e.getBindingResult();
        String message = null;
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            if (fieldError != null) {
                message = fieldError.getField()+fieldError.getDefaultMessage();
            }
        }
        return ResultData.validateFailed(message);
    }

}
