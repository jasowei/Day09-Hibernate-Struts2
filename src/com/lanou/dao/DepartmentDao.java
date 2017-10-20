package com.lanou.dao;

import com.lanou.domain.Department;


/**
 * Created by dllo on 17/10/20.
 */
public interface DepartmentDao extends BaseDao<Department> {

    //根据id查询某个部门
    Department findById(int departId);

    //

}
