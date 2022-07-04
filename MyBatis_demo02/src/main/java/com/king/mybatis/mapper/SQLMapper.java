package com.king.mybatis.mapper;

import com.king.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SQLMapper {

    /**
     * 根据用户名模糊查询用户信息
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 批量删除
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 动态设置表名
     */
    List<User> getUserByTableName(@Param("tableName") String tableName);

    /**
     * 添加用户信息，添加功能获取自增的主键
     */
    void insertUser(User user);


}
