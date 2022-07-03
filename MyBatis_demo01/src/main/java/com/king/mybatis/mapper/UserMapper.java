package com.king.mybatis.mapper;

import com.king.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {

    /**
     * MyBatis面向接口的两个一致
     * 1. 映射文件的namespace要和Mapper接口的全类名一致
     * 2. 映射文件中的sql语句的id要和mapper接口中的方法名一致
     */

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    void updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有用户信息
     */
    List<User> getAllUser();

}
