package com.king.mybatis.test;

import com.king.mybatis.mapper.ParameterMapper;
import com.king.mybatis.pojo.User;
import com.king.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Mainx
 * @version 1.0
 * @description: TODO
 * @date 2022/7/3 19:23
 */
public class ParameterMapperTest {
    /**
     * MyBatis获取参数值得两种方式：${}、#{}
     * ${} 本质字符串拼接
     * #{} 本质占位符赋值
     * MyBatis获取参数值的各种情况：
     * 1. mapper接口方法的参数为单个的字面量类型
     *    可以通过${} 和 #{} 以任意的名称获取参数值，但是需要注意 ${}的单引号问题
     */

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void testGetUserByUserName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.GetUserByUserName("admin");
        System.out.println(user);
    }
}
