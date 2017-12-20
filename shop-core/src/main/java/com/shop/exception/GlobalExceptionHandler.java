package com.shop.exception;

import com.shop.constant.MessageModel;
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
    public MessageModel handlerParam(ParamException exception) {
        MessageModel messageModel = new MessageModel();
        messageModel.setMsg(exception.getMessage());
        messageModel.setData(exception.getMessage());
        messageModel.setCode(exception.getErrorCode());
        return messageModel;
    }

}
