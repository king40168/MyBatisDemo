import com.king.mybatis.mapper.DeptMapper;
import com.king.mybatis.mapper.EmpMapper;
import com.king.mybatis.pojo.Dept;
import com.king.mybatis.pojo.Emp;
import com.king.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author Mainx
 * @version 1.0
 * @description: TODO
 * @date 2022/7/4 19:51
 */
public class ResultMapTest {

    /**
     * 解决字段名和属性名不一致的情况
     * 1. 为字段其别名来保持和属性名的一致
     * 2. 使用mapUnderscoreToCamerCase,设置全局配置，将下划线_自动映射为驼峰
     * 3. 为字段起别名，保证和实体类中的属性名保持一致
     *
     *
     * 多对一映射处理
     * 1. 使用级联方式处理
     * 2. 使用association处理
     * 3. 分步处理
     */

    @Test
    public void testGetAllEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> allEmp = mapper.getAllEmp();
        allEmp.forEach(emp -> System.out.println(emp));
    }

    //通过级联属性处理映射关系方法1
    @Test
    public void testGetEmpAndDept() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptOne(1);
        System.out.println(emp);
    }

    //通过级联属性处理映射关系方法2
    @Test
    public void testGetEmpAndDeptTwo() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptTwo(3);
        System.out.println(emp);
    }

    //分步查询员工信息
    @Test
    public void testGetEmpAndDeptByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDepByStepOne(3);
        System.out.println(emp.getEmpName());
        System.out.println("---------------------");
        System.out.println(emp.getDept());
    }

    //处理一对多映射关系：使用collection标签
    @Test
    public void testGetDeptAndEmp() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    //分步查询
    @Test
    public void testGetDeptAndEmpByStep() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStepOne(1);
        System.out.println(dept.getDeptName());
    }
}
