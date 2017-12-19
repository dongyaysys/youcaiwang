package com.shop.service;

import com.shop.dao.UserDao;
import com.shop.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public String[] showRecentBrand(){


        return userDao.showRecentBrand();
    }

}
