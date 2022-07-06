package com.king.mybatis.test;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.king.mybatis.mapper.EmpMapper;
import com.king.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Mainx
 * @version 1.0
 * @description: 分页测试类
 * @date 2022/7/6 21:42
 */
public class PageHelpTest {
    /**
     * 分页
     * 在查询语句后面使用limit关键字
     *  index: 当前页的起始索引，从0开始
     *  pageSize: 每页显示的条数
     *  pageNum: 当前页的页码
     *  index = (pageNum - 1) * pageSize
     *
     *  使用MyBatis的分页插件实现分页
     *
     */

    @Test
    public void testPageHelper() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询功能前开启分页，访问第一页，每页4条数据
//            Page<Object> page = PageHelper.startPage(1, 4);
            PageHelper.startPage(2, 4);
            List<Emp> list = mapper.selectByExample(null);
            PageInfo<Emp> pageInfo = new PageInfo<>(list, 5);
//            list.forEach(emp -> System.out.println(emp));
            System.out.println(pageInfo);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
