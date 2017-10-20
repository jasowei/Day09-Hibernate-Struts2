package com.lanou.dao.impl;

import com.lanou.dao.DepartmentDao;
import com.lanou.domain.Department;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {
    @Override
    public Department findById(int departId) {
        String hql = "from Department where id=:id";
        Map<String,Object> params = new HashMap();
        params.put("id",departId);
        return findSingle(hql,params);
    }
}
