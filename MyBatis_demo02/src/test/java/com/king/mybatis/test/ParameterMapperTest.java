package com.king.mybatis.test;

import com.king.mybatis.mapper.ParameterMapper;
import com.king.mybatis.pojo.User;
import com.king.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
     * 2. mapper接口中的方法参数为多个时
     *    此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     *    a->以arg0，arg1...为键，以参数为值
     *    b->以param1，param2...为键，以参数为值
     *    因此只需要通过#{}、${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 3. 若mapper接口的方法有多个时，可以手动将这些参数放在一个map中进行存储
     *    需要通过#{}、${}以键的方式访问值即可，但是需要注意${}的单引号问题
     * 4. mapper接口方法的参数是实体类类型的参数
     *    通过访问实体类对象中的属性名获取属性值，注意${}需要手动加单引号
     * 5. 使用@param标识参数
     *    此时MyBatis会将这些参数放在一个map集合中，以两种方式进行存储
     *    a->以@Param注解的值为键，以参数为值
     *    b->以param1，param2...为键，以参数为值
     *    因此只需要通过#{}、${}以键的方式访问值即可，但是需要注意${}的单引号问题
     */

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        List<User> list = mapper.getAllUser();
        list.forEach(System.out::println);
    }

    //单个字面量类型的参数
    @Test
    public void testGetUserByUserName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.GetUserByUserName("admin");
        System.out.println(user);
    }

    //多个字面量类型的参数
    @Test
    public void testCheckLogin() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLogin("admin","123456");
        System.out.println(user);
    }

    //map集合类型的参数
    @Test
    public void testCheckLoginByMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "123456");
        User user = mapper.checkLoginByMap(map);
        System.out.println(user);
    }

    //使用@Param标识的参数
    @Test
    public void testCheckLoginByParam() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        User user = mapper.checkLoginByParam("admin","123456");
        System.out.println(user);
    }

    //实体类类型的参数
    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        ParameterMapper mapper = sqlSession.getMapper(ParameterMapper.class);
        int i = mapper.insertUser(new User(null, "小明", "123", 25, "男", "123@qq.com"));
        System.out.println(i);
    }
}
