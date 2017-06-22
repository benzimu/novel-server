package com.hjj.ben.dao;

import java.util.List;

/**
 * Created by ben on 6/22/17.
 */
public interface IBaseDao {
    /**
     * 添加或者更新数据
     * @param entity
     */
    public void saveOrUpdate(Object entity);

    /**
     * 删除数据
     * @param entity
     */
    public void delete(Object entity);

    /**
     * 获取所有数据
     * @param clazz
     * @return
     */
    public List<?> getAll(Class clazz);

    /**
     * 通过id获取数据
     * @param id
     * @param clazz
     * @return
     */
    public Object getById(Integer id, Class clazz);

    /**
     * 通过小说详情ID获取目录
     * @param novelDetailId
     * @param clazz
     * @return
     */
    public List<?> getCatalog(Integer novelDetailId, Class clazz);
}
