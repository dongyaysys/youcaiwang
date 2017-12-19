package com.shop.controller;

import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.gto.GoodsDto;
import com.shop.service.GoodsService;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 17173 on 2017/12/7.
 */
@Controller
@RequestMapping("product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @RequestMapping("productDetail")
    @ResponseBody
    public MessageModel productDetail(Integer id,GoodsDto goodsDto){

        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        map=productService.productDetail(id,goodsDto);
        messageModel.setData(map);
        messageModel.setCode(DmConstant.opscode(map));
        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        return messageModel;



    }



}
