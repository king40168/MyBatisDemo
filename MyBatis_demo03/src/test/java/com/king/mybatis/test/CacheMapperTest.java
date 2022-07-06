package com.king.mybatis.test;

import com.king.mybatis.mapper.CacheMapper;
import com.king.mybatis.pojo.Emp;
import com.king.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Mainx
 * @version 1.0
 * @description: MyBatis缓存测试类
 * @date 2022/7/6 15:52
 */
public class CacheMapperTest {

    //一级缓存
    @Test
    public void testOneCache() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEid(1);
        System.out.println(emp1);
        //任何的一次增删改查都会清空缓存
        //mapper1.insertEmp(new Emp(null,"a3",21,"男","123@qq.com"));
        //手动清空一级缓存
        sqlSession.clearCache();
        Emp emp2 = mapper1.getEmpByEid(1);
        System.out.println(emp2);
    }

    //测试二级缓存
    @Test
    public void testTwoCache() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(1));
            sqlSession1.close();
            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSession2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
