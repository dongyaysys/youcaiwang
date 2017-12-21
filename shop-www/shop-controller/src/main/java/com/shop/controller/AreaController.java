package com.shop.controller;

import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.service.AreaService;
import com.shop.service.WishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 17173 on 2017/12/7.
 * 添加收货地址
 */
@Controller
@RequestMapping("addArea")
public class AreaController {


    @Autowired
    private AreaService areaService;
    /**
    *@author DY
    *@create 2017/12/21 12:02
    *添加收货地址
    */
    @RequestMapping("addOrUpdateReceiverAddress")
    @ResponseBody
    public MessageModel addOrUpdateReceiverAddress(Integer userId,Integer areaId,String people,String mobile,String area,String detailPlace){

        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();
        messageModel=areaService.addOrUpdateReviewAddress(userId,areaId,people,mobile,area,detailPlace);
        return messageModel;

    }
    /**
    *@author DY
    *@create 2017/12/21 12:02
    *列出收货地址
    */
    @RequestMapping("showReceiverAddress")
    @ResponseBody
    public MessageModel showReviewAddress(Integer userId){

        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();
        messageModel=areaService.showReviewAddress(userId);
        return messageModel;

    }
    /**
    *@author DY
    *@create 2017/12/21 12:02
    *修改默认收货地址
    */
    @RequestMapping("updateDefaultReceiverAddress")
    @ResponseBody
    public MessageModel updateDefaultReviewAddress(Integer userId,Integer receiverId){

        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();
        messageModel=areaService.updateDefaultReviewAddress(userId,receiverId);
        return messageModel;

    }





}
