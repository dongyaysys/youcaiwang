package com.shop.controller;

import com.alibaba.fastjson.JSON;
import com.shop.constant.DmConstant;
import com.shop.constant.MessageModel;
import com.shop.dao.DesignerDao;
import com.shop.dao.GoodsDao;
import com.shop.gto.GoodsDto;
import com.shop.model.User;
import com.shop.query.BrandQuery;
import com.shop.query.DesignerQuery;
import com.shop.query.GoodsQuery;
import com.shop.service.UserService;
import com.sun.org.apache.xpath.internal.SourceTree;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.net.ssl.SSLContext;
import java.lang.reflect.Method;
import java.text.Collator;
import java.util.*;

/**
 * Created by 17173 on 2017/12/5.
 */
@Controller
@RequestMapping("user")
public class UserController {



    @Autowired
    private UserService userService;
    @Autowired
    private DesignerDao designerDao;



    @RequestMapping("find")
    @ResponseBody
    public User findById(User u){
        User user=userService.findById(u);
        return user;
    }



}
