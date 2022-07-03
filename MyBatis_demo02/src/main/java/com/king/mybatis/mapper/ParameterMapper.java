package com.king.mybatis.mapper;

import com.king.mybatis.pojo.User;

import java.util.List;

public interface ParameterMapper {

    /**
     * 根据用户名查询用户信息
     */
    User GetUserByUserName(String username);


    /*查询所有员工信息*/
    List<User> getAllUser();


}
