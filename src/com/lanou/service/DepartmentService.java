package com.lanou.service;

import com.lanou.domain.Department;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public interface DepartmentService {

    List<Department> findAll();

    Department findById(int departId);

    List<Department> find(String hql, Map<String,Object> params);
}
