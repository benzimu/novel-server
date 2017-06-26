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
    void saveOrUpdate(Object entity);

    /**
     * 删除数据
     * @param entity
     */
    void delete(Object entity);

    /**
     * 获取所有数据
     * @param clazz
     * @return
     */
    List<?> getAll(Class clazz);

    /**
     * 通过id获取数据
     * @param id
     * @param clazz
     * @return
     */
    Object getById(Integer id, Class clazz);

    /**
     * 通过小说详情ID获取目录
     * @param novelDetailId
     * @param reverseFlag
     * @param clazz
     * @return
     */
    List<?> getCatalog(Integer novelDetailId, String reverseFlag, Class clazz);

    /**
     * 获取当前数据的前一条
     * @param curResId
     * @param novelDetailId
     *@param clazz  @return
     */
    Object getLastItem(Integer curResId, Integer novelDetailId, Class clazz);

    /**
     * 获取当前数据的后一条
     * @param curResId
     * @param novelDetailId
     *@param clazz  @return
     */
    Object getNextItem(Integer curResId, Integer novelDetailId, Class clazz);

}
