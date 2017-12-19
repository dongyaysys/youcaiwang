package com.shop.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by TW on 2017/10/25.
 */
@ControllerAdvice
public class GlobalExceptionHandler {


    /**
     * 处理ParamException异常
     * @param exception
     * @return json
     */
    @ExceptionHandler(value = ParamException.class)
    @ResponseBody
    public ResultInfo handlerParam(ParamException exception) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResultMessage(exception.getMessage());
        resultInfo.setResult(exception.getMessage());
        resultInfo.setResultCode(exception.getErrorCode());
        return resultInfo;
    }

}
