package com.shop.service;

import com.shop.constant.DmConstant;
import com.shop.constant.JedisConstant;
import com.shop.constant.MessageModel;
import com.shop.dao.UserDao;
import com.shop.model.User;
import com.shop.util.AssertUtil;
import com.shop.util.MobileUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by 17173 on 2017/12/5.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User findById(User u){

        User user=userDao.findById(u);
        return user;
    }

    public MessageModel userLogin(String mobile) {

        AssertUtil.isNotEmpty(mobile,"手机号不能为空");
        Map<Object,Object> map= new HashMap<Object,Object>();
        MessageModel messageModel=new MessageModel();
        User userNew=new User();
        User user=userDao.findUserByMobile(mobile);
        if(null==user){
            Integer insertCode=userDao.insertUser(mobile);
                if(null==insertCode||insertCode<1){
                    messageModel.setCode(DmConstant.OPS_FAILED_CODE);
                    messageModel.setMsg(DmConstant.OPS_FAILED_MSG);
            }
                else{
                    userNew.setIsLogin(true);
                    userNew.setMobile(mobile);
                    userNew.setNickname(mobile);
                    map.put("user",userNew);
                    messageModel.setCode(DmConstant.OPS_SUCCESS_CODE);
                    messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);

                }
        }

        else{
            user.setIsLogin(true);
            map.put("user",user);
            messageModel.setCode(DmConstant.OPS_SUCCESS_CODE);
            messageModel.setMsg(DmConstant.OPS_SUCCESS_MSG);
        }

        //构建token
        Jedis jedis=new Jedis(JedisConstant.JEDISHOST, JedisConstant.JEDISPORT);
        jedis.auth(JedisConstant.POSSWORD);

        String newMobile= MobileUtil.returnNewMobile(mobile);
        //构建token之前判断是否有token存在
        String token=jedis.get(newMobile);
        if(null!=token){
            jedis.del(token);
        }

        String value=DigestUtils.md5Hex(UUID.randomUUID().toString().getBytes());
                jedis.set(newMobile,value);
                jedis.expire(newMobile,300);
                map.put(mobile,value);
                messageModel.setData(map);
                return messageModel;

    }


}
