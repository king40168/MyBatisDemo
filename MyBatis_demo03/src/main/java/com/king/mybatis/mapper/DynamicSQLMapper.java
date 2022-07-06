package com.king.mybatis.mapper;

import com.king.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {

    /**
     * 动态SQl
     * if
     */
    List<Emp> getEmpByConditionOne(Emp emp);
    /**
     * 动态SQl
     * where
     */
    List<Emp> getEmpByConditionTwo(Emp emp);
    /**
     * 动态SQl
     * trim
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 动态SQl
     * choose when otherwise
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 动态SQL
     * foreach 通过数组实现批量删除
     */
    int deleteMoreByArray(@Param("eids") Integer[] eids);

    /**
     * 通过list集合实现批量添加
     */
    int insertMoreByList(@Param("emps") List<Emp> emps);

}
