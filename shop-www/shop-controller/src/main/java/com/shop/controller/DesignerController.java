package com.shop.controller;

import com.shop.base.BaseModel;
import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.gto.GoodsDto;
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
@RequestMapping("designer")
public class DesignerController  extends BaseModel implements Serializable{


    @Autowired
    private DesignerService designerService;

    /**
     *@author DY
     *@create 2017/12/13 10:31
     *选衣--男装女装接口
     */
    @RequestMapping("showDesignerDetail")
    @ResponseBody
    public MessageModel showDesignerDetail(Integer id, GoodsDto goodsDto){
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        map=designerService.showDesignerDetail(id,goodsDto);
        messageModel.setData(map);
        messageModel.setCode(DmConstant.opscode(map));
        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        return messageModel;

    }

}
