package com.lanou.service.impl;

import com.lanou.dao.DepartmentDao;
import com.lanou.dao.impl.DepartmentDaoImpl;
import com.lanou.domain.Department;
import com.lanou.service.DepartmentService;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentDao departmentDao;

    public DepartmentServiceImpl() {
        departmentDao = new DepartmentDaoImpl();
    }

    @Override
    public List<Department> findAll() {
        String hql = "from Department";
        return departmentDao.findAll(hql);
    }

    @Override
    public Department findById(int departId) {
        return departmentDao.findById(departId);
    }

    @Override
    public List<Department> find(String hql, Map<String, Object> params) {
        return departmentDao.find(hql,params);
    }
}
