package com.shop.controller;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.gto.GoodsDto;
import com.shop.model.Goods;
import com.shop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    /**
    *@author DY
    *@create 2017/12/21 12:02
    *查看商品详情
    */
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

    /**
    *@author DY
    *@create 2017/12/21 12:04
    *搜索
    */
    @RequestMapping("search")
    @ResponseBody
    public MessageModel selectProductForPage(GoodsDto goodsDto){
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        map=productService.selectProductForPage(goodsDto);

        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        messageModel.setData(map);
        messageModel.setCode(DmConstant.opscode(map));
        return messageModel;

    }










}
