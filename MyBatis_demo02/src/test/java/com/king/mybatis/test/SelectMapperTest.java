package com.king.mybatis.test;

import com.king.mybatis.mapper.SelectMapper;
import com.king.mybatis.pojo.User;
import com.king.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author Mainx
 * @version 1.0
 * @description: TODO
 * @date 2022/7/4 9:46
 */
public class SelectMapperTest {

    /**
     * MyBatis各种查询功能：
     * 1. 若查询的数据结果只有一条，可以通过实体类对象接收
     * 2. 若查询的结果数据有多条，一定不能通过实体类对象接收，此时会抛异常TooManyResultException，需要以集合来接收
     *    List<>集合接收
     *
     * MyBatis中设置了默认的类型别名
     *
     */

    //通过id查询用户信息
    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(8);
        System.out.println(user);
    }

    //查询数目
    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    //查询一条数据为map集合
    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getUserByIdToMap(8);
        System.out.println(map);
    }

    //查询多条数据为map集合，使用@MapKey()
    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> map = mapper.getAllUserToMap();
        System.out.println(map);
    }
}
