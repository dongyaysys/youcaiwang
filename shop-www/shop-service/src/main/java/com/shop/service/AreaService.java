package com.shop.service;/**
 * Created by 17173 on 2017/12/21.
 */

import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.dao.AreaDao;
import com.shop.model.Receiver;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DY
 * @create 2017-12-21 18:04
 **/
@Service
public class AreaService {

    @Autowired
    private AreaDao areaDao;

    public MessageModel addOrUpdateReviewAddress(Integer userId,Integer areaId, String people,
                                         String mobile, String area, String detailPlace) {
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();
        //判断是修改还是添加收货地址
        Integer code=null;
        if(null==areaId||areaId<1){

            checkParemas(userId,people,mobile,area,detailPlace);
            code=areaDao.queryAreaExist(userId);
            if(null==code||code<1){
                code=areaDao.insertAreaDefaule(userId,people,mobile,area,detailPlace);
            }
            else{

                code=areaDao.insertArea(userId,people,mobile,area,detailPlace);
            }
            AssertUtil.intIsNotEmpty(code,"新增失败");
        }
        else{
            checkParemas(areaId,people,mobile,area,detailPlace);
            code=areaDao.updateArea(people,mobile,area,detailPlace,areaId);
            AssertUtil.intIsNotEmpty(code,"修改失败");
        }



        messageModel.setCode(DmConstant.OPS_SUCCESS_CODE);
        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        return messageModel;

    }



    private void checkParemas(Integer userId, String people,
                              String mobile, String area, String detailPlace){

        AssertUtil.intIsNotEmpty(userId,"请登录或者选择要修改的地址");
        AssertUtil.isNotEmpty(people,"请填写收货人");
        AssertUtil.isNotEmpty(area,"请填写收货地址");
        AssertUtil.isNotEmpty(detailPlace,"请填写收货详细地址");

    }

    public MessageModel showReviewAddress(Integer userId) {
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();
        AssertUtil.intIsNotEmpty(userId,"请传入用户Id");
        List<Receiver> reeceiver=areaDao.queryReceviewByUserId(userId);

        map.put("reeceiver",reeceiver);
        if(null==reeceiver||reeceiver.size()==0){
            map=null;
        }
        messageModel.setData(map);
        messageModel.setCode(DmConstant.opscode(map));
        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);

        return messageModel;

    }

    public MessageModel updateDefaultReviewAddress(Integer userId, Integer receiverId) {
        MessageModel messageModel=new MessageModel();
        Map<Object,Object> map= new HashMap<Object,Object>();
        AssertUtil.intIsNotEmpty(userId,"修改用户不能为空");
        AssertUtil.intIsNotEmpty(receiverId,"请传入修改的地址");

        //修改之前把之前的默认地址改为非默认
        Integer code=null;
        code=areaDao.deleteDefaultCode(userId);
        AssertUtil.intIsNotEmpty(code,"修改默认地址失败");
        //把新的地址设为默认
        code=areaDao.updateDefaultCode(userId,receiverId);
        AssertUtil.intIsNotEmpty(code,"修改默认地址失败");

        messageModel.setCode(DmConstant.OPS_SUCCESS_CODE);
        messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);

        return messageModel;

    }
}
