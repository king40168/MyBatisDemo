package com.king.mybatis.mapper;

import com.king.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {
    /**
     * 查询所有的员工信息
     */
    List<Emp> getAllEmpOld();

    List<Emp> getAllEmp();

    /**
     * 查询员工以及员工所对应的部门信息
     */
    Emp getEmpAndDeptOne(@Param("eid") Integer eid);

    Emp getEmpAndDeptTwo(@Param("eid") Integer eid);

    /**
     * 通过分步查询员工及部门信息
     * 1. 查询员工信息
     */
    Emp getEmpAndDepByStepOne(@Param("eid") Integer eid);


}
