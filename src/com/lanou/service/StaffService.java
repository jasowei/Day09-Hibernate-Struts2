package com.lanou.service;

import com.lanou.domain.Staff;

import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public interface StaffService {

    /**
     * 查询所有
     * @return
     */
    List<Staff> findAll();

    /**
     * 条件模糊查询
     * @param hql
     * @param params
     * @return
     */
    List<Staff> find(String hql, Map<String,Object> params);


}
