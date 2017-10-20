package com.lanou.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/20.
 */
public interface BaseDao<T> {

    /**
     * 查询所有
     */
    List<T> findAll(String hql);

    /**
     * 根据条件查询, 返回查询到的结果集
     */
    List<T> find(String hql, Map<String,Object> params);

    /**
     * 根据条件查询, 返回第一个对象
     */
    T findSingle(String hql, Map<String,Object> params);

    /**
     * 根据主键id查询某个对象
     * @param id 要查询的主键id
     * @param tClass 返回对象类型声明
     * @return
     */
    T findById(Serializable id,Class<T> tClass);
}
