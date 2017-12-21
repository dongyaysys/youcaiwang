package com.shop.service;

import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.dao.AttendDao;
import com.shop.dao.UserDao;
import com.shop.exception.ParamException;
import com.shop.model.User;
import com.shop.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 17173 on 2017/12/8.
 * 收藏商品和关注品牌
 */
@Service
public class AttendService {


    @Autowired
    private AttendDao attendDao;
    @Autowired
    private UserDao userDao;


    public MessageModel attendDesignerOrBrand(Integer userId,Integer attend,Integer click,Integer type) {
        MessageModel messageModel=new MessageModel();

        AssertUtil.intIsNotEmpty(userId,"请选择用户");
        User user=userDao.findUserById(userId);
        if(user==null){
            throw new ParamException("查询不到此用户");
        }

        AssertUtil.intIsNotEmpty(attend,"请选择要关注的设计师或者品牌");
        AssertUtil.intIsNotEmpty(type,"请选择关注类型");
        Integer code=attendDao.findIsAttendById(userId,attend,type);
        Boolean isAttend=null;
        if(null==click||click<1){
            if(null==code||code<1){
                isAttend=false;
            }
            else{
                isAttend=true;
            }

        }
        else{
            //判断此用户是否点赞,true代表点赞
            if(null==code||code<1){
                isAttend=true;
                Integer insertCode=attendDao.insertAttend(userId,attend,type);
                AssertUtil.intIsNotEmpty(insertCode,"关注失败");
                messageModel.setCode(DmConstant.OPS_SUCCESS_CODE);
                messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
            }
            else{
                isAttend=false;
                Integer deleteCode=attendDao.deleteAttend(userId,attend,type);
                AssertUtil.intIsNotEmpty(deleteCode,"取消失败");
                messageModel.setCode(DmConstant.OPS_SUCCESS_CODE);
                messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
            }
        }

            messageModel.setData(isAttend);
            return messageModel;
    }

    public MessageModel collectionGoods(Integer userId, Integer goodsId,Integer click) {
        MessageModel messageModel=new MessageModel();

        AssertUtil.intIsNotEmpty(userId,"请选择用户");
        User user=userDao.findUserById(userId);
        if(user==null){
            throw new ParamException("查询不到此用户");
        }
        AssertUtil.intIsNotEmpty(goodsId,"请选择要收藏的商品");
        Integer code=attendDao.findIsCollectionById(userId,goodsId);
        Boolean isCollection=null;
        //判断此用户是否点赞,true代表点赞

        if(null==click||click<1){
            if(null==code||code<1){
                isCollection=false;
            }
            else{
                isCollection=true;
            }

        }

        else{

            if(null==code||code<1){
                isCollection=true;
                Integer insertCode=attendDao.insertCollection(userId,goodsId);
                AssertUtil.intIsNotEmpty(insertCode,"收藏失败");
                messageModel.setCode(DmConstant.OPS_SUCCESS_CODE);
                messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
            }
            else{
                isCollection=false;
                Integer deleteCode=attendDao.deleteCollection(userId,goodsId);
                AssertUtil.intIsNotEmpty(deleteCode,"取消收藏失败");
                messageModel.setCode(DmConstant.OPS_SUCCESS_CODE);
                messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
            }
        }

        messageModel.setData(isCollection);
        return messageModel;


    }
}
