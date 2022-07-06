package com.king.mybatis.mapper;

import com.king.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {

    /**
     * 处理多对一的映射关系
     * 通过分步查询员工及部门信息
     * 1. 通过员工的did来查询员工所对应的部门
     */
    Dept getEmpAndDeptByStepTwo(@Param("did") Integer did);

    /**
     * 处理一对多的映射关系
     */
    Dept getDeptAndEmp(@Param("did") Integer did);

    /**
     * 处理一对多的映射关系
     * 分步查询部门以及所有的员工信息
     * 1. 查询部门信息
     */
    Dept getDeptAndEmpByStepOne(@Param("did") Integer did);


}
