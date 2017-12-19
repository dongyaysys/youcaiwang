package com.shop.base;

import com.shop.constant.Constant;
import com.shop.exception.ResultInfo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by TW on 2017/10/26.
 */
public class BaseController {

    @ModelAttribute
    public void preMethod(Model model, HttpServletRequest request) {
        model.addAttribute("ctx", request.getContextPath());
    }

    /**
     * 成功
     * @param message
     * @return
     */
    protected ResultInfo success(String message) {
        ResultInfo resultInfo = buildResultInfo(Constant.SUCCESS_CODE, message);
        return resultInfo;
    }

    protected ResultInfo success(Object result, String message) {
        ResultInfo resultInfo = buildResultInfo(Constant.SUCCESS_CODE, message, result);
        return resultInfo;
    }


    /**
     * 成功
     * @param message
     * @return
     */
    protected ResultInfo failure(String message) {
        ResultInfo resultInfo = buildResultInfo(Constant.ERROR_CODE, message);
        return resultInfo;
    }

    protected ResultInfo failure(Integer resultCode, String message) {
        ResultInfo resultInfo = buildResultInfo(resultCode, message);
        return resultInfo;
    }

    /**
     * 构建返回结果
     * @param code
     * @param message
     * @return
     */
    protected ResultInfo buildResultInfo(Integer code, String message) {
        return buildResultInfo(code, message, null);
    }

    /**
     * 构建返回结果
     * @param code
     * @param message
     * @param result
     * @return
     */
    protected ResultInfo buildResultInfo(Integer code, String message, Object result) {
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setResultCode(code);
        resultInfo.setResultMessage(message);
        resultInfo.setResult(result);
        return resultInfo;
    }

}
