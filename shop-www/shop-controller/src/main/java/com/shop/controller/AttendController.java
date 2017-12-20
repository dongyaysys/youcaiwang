package com.shop.controller;

import com.shop.base.BaseModel;
import com.shop.constant.MessageModel;
import com.shop.gto.Token;
import com.shop.service.AttendService;
import com.shop.util.AssertUtil;
import com.shop.util.IsLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 17173 on 2017/12/8.
 *关注收藏表
 */
@Controller
@RequestMapping("attend")
public class AttendController extends BaseModel implements Serializable{


    @Autowired
    private AttendService attendService;

    /**
    *@author DY
    *@create 2017/12/15 10:20
    *关注设计师和收藏宝贝
    */

    @RequestMapping("attendDesignerOrBrand")
    @ResponseBody
    public MessageModel attendDesignerOrBrand(Integer userId,Integer attend,Integer type,Token token){

        Boolean isLogin=IsLogin.isLogin(token);
        AssertUtil.isTrue(!isLogin,"异常访问");
        MessageModel messageMode=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        MessageModel messageModel=attendService.attendDesignerOrBrand(userId,attend,type);
        return messageModel;

    }

    @RequestMapping("collectionProduct")
    @ResponseBody
    public MessageModel collectionProduct(Integer userId,Integer goodsId,Token token){
        Boolean isLogin=IsLogin.isLogin(token);
        AssertUtil.isTrue(!isLogin,"异常访问");
        MessageModel messageMode=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        MessageModel messageModel=attendService.collectionGoods(userId,goodsId);
        return messageModel;

    }






}
