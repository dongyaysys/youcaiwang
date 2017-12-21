package com.shop.controller;

import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.gto.GoodsDto;
import com.shop.service.ProductService;
import com.shop.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 17173 on 2017/12/7.
 */
@Controller
@RequestMapping("wish")
public class WishController {


    @Autowired
    private WishService wishService;
    /**
    *@author DY
    *@create 2017/12/21 12:02
    *查看商品详情
    */
    @RequestMapping("findWish")
    @ResponseBody
    public MessageModel findWish(Integer userId){

        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        map=wishService.findWish(userId);
        messageModel.setData(map);
        messageModel.setCode(DmConstant.opscode(map));
        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        return messageModel;

    }




}
