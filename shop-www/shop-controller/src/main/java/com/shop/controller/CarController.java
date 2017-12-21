package com.shop.controller;

import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.gto.GoodsDto;
import com.shop.service.ProductService;
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
@RequestMapping("car")
public class CarController {


    @Autowired
    private ProductService productService;

    /**
    *@author DY
    *@create 2017/12/19 14:18
    *加入购物车,判断是否为定制类产品,定制类不判断库存
    */
   @RequestMapping("choseSizeOrMaterial")
    @ResponseBody
    public MessageModel addProductCar(GoodsDto goodsDto){

        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        map=productService.chooseProduct(goodsDto);
        messageModel.setData(map);
        messageModel.setCode(DmConstant.opscode(map));
        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        return messageModel;

    }






}
