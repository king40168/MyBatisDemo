package com.king.mybatis.test;

import com.king.mybatis.mapper.DynamicSQLMapper;
import com.king.mybatis.pojo.Emp;
import com.king.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Mainx
 * @version 1.0
 * @description: 动态SQL测试类
 * @date 2022/7/5 10:57
 */
public class DynamicSQLTest {

    /**
     * 动态SQL
     * 1. if：根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到SQL中
     * 2. where：标签中有内容时，会自动生成where关键字，并且将内容前多余的的and\or去掉
     *           标签中没有内容时，此时where标签没有任何效果
     *           注意：where标签不能将其中内容后面的多余的and\or去掉
     * 3. foreach
     *      collection：设置需要循环的数组或集合
     *      item：表示数组或集合中的每一个数据
     *      separator：循环体之间的分隔符
     *      open：foreach标签所循环的所有内容的开始符
     *      close：foreach标签所循环的所有内容的结束符
     *
     * 4.SQL片段
     *      可以引入需要经常查询的字段，之后直接查询就可以了
     *      设置SQL片段：<sql id="empColumns">eid,emp_name,age,sex,email</sql>
     *      引用SQL片段：<include refid="empColumns"/>
     */


    @Test
    public void testGetEmpByCondition() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByCondition(new Emp(null, "张三",23, "男", "123@qq.com"));
        System.out.println(list);
    }

    //测试choose when otherwise
    @Test
    public void testGetEmpByChoose() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        List<Emp> list = mapper.getEmpByChoose(new Emp(null, null, null, null, null));
        System.out.println(list);
    }

    //测试foreach循环删除
    @Test
    public void testDeleteMoreByArray() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArray(new Integer[] {6,7,8,});
        System.out.println(result);
    }

    //测试使用list  foreach插入数据
    @Test
    public void testInsertMoreByList() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null,"a",25,"男","123@qq.com");
        Emp emp2 = new Emp(null,"b",16,"男","123@qq.com");
        Emp emp3 = new Emp(null,"c",23,"男","123@qq.com");
        List<Emp> emps = Arrays.asList(emp1, emp2, emp3);
        int result = mapper.insertMoreByList(emps);
        System.out.println(result);
    }

}
