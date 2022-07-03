package com.king.mybatis.mapper;

import com.king.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    /**
     * 根据用户名查询用户信息
     */
    User GetUserByUserName(String username);

    /**
     * 验证登录
     */
    User checkLogin(String username, String password);

    /**
     * 验证登录（参数为map）
     */
    User checkLoginByMap(Map<String,Object> map);

    /**
     * 验证登录（使用@Param注解）
     */
    User checkLoginByParam(@Param("username") String username,@Param("password")  String password);

    /**
     * 添加用户信息
     */
    int insertUser(User user);

    /*查询所有员工信息*/
    List<User> getAllUser();


}
