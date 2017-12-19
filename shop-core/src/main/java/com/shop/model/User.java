package com.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shop.base.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by TW on 2017/10/23.
 */
@Getter
@Setter
public class User  implements Serializable {

    private Integer userId;

    //创建日期
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createDate;
    //修改日期
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date modifyDate;
    //用户头像
    private String avatar;
    //用户手机
    private String mobile;
    //昵称
    private String nickname;
    //用户邮箱
    private String email;
    //用户性别
    private String sex;
    //用户生日
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;
    //是否登录
    private Boolean isLogin;

}
