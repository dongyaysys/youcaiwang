package com.shop.controller;

import com.shop.base.BaseModel;
import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.gto.GoodsDto;
import com.shop.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import scala.Serializable;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by 17173 on 2017/12/8.
 *首页面展示
 */
@Controller
@RequestMapping("show")
public class ShowController extends BaseModel implements Serializable {

    @Autowired
    private IndexService indexService;

/**
*@author DY
*@create 2017/12/12 19:33
*秀场推荐展示
*/
    @RequestMapping("recommend")
    @ResponseBody
    public MessageModel recommendShow(){
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        map=indexService.recommendShow();

        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        messageModel.setData(map);
        messageModel.setCode(DmConstant.opscode(map));


        return messageModel;

    }

    /**
    *@author DY
    *@create 2017/12/12 12:06
    *秀场Look展示
    */
    @RequestMapping("look")
    @ResponseBody
    public MessageModel lookShow(GoodsDto goodsDto){
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        map=indexService.lookShow(goodsDto);
        messageModel.setData(map);
        messageModel.setCode(DmConstant.opscode(map));
        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        return messageModel;

    }
  /**
  *@author DY
  *@create 2017/12/13 10:31
  *选衣--男装女装接口
  */
    @RequestMapping("chooseClose")
    @ResponseBody
    public MessageModel chooseClose(GoodsDto goodsDto){
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        map=indexService.chooseShow(goodsDto);
        messageModel.setData(map);
        messageModel.setCode(DmConstant.opscode(map));
        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        return messageModel;

    }



  /**
  *@author DY
  *@create 2017/12/13 10:31
  *选衣--男装女装接口
  */
    @RequestMapping("showBrandDesigner")
    @ResponseBody
    public MessageModel showBrandDesigner(Integer type){
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();

        map=indexService.showBrandDesigner(type);
        messageModel.setData(map);
        messageModel.setCode(DmConstant.opscode(map));
        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        return messageModel;
    }





}
