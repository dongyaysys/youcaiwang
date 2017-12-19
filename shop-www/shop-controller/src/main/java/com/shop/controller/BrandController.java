package com.shop.controller;

import com.shop.base.BaseModel;
import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.service.BrandService;
import com.shop.service.DesignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 17173 on 2017/12/8.
 *
 */
@Controller
@RequestMapping("brand")
public class BrandController extends BaseModel implements Serializable{


    @Autowired
    private BrandService brandService;

    /**
     *@author DY
     *@create 2017/12/13 10:31
     *选衣--男装女装接口
     */
    @RequestMapping("showBrandDetail")
    @ResponseBody
    public MessageModel showBrandDetail(Integer id){
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        map=brandService.showBrandDetail(id);
        messageModel.setData(map);
        messageModel.setCode(DmConstant.opscode(map));
        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        return messageModel;

    }





}
