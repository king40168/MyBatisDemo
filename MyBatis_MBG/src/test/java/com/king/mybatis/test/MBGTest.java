package com.king.mybatis.test;

import com.king.mybatis.mapper.EmpMapper;
import com.king.mybatis.pojo.Emp;
import com.king.mybatis.pojo.EmpExample;
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
 * @description: MyBatis Generator逆向生成器测试类
 * @date 2022/7/6 20:43
 */
public class MBGTest {

    @Test
    public void testMBG() {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
            //查询所有数据
            /*List<Emp> list = mapper.selectByExample(null);
            list.forEach(emp -> System.out.println(emp));*/
            //根据条件查询
            /*EmpExample example = new EmpExample();
            //条件可以进行拼接
            example.createCriteria().andAgeGreaterThanOrEqualTo(24);
            example.or().andDidEqualTo(1);
            List<Emp> list = mapper.selectByExample(example);
            System.out.println(list);*/

            int result = mapper.updateByPrimaryKeySelective(new Emp(1, "admin", 22, "男", "456@qq.com",3));
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
