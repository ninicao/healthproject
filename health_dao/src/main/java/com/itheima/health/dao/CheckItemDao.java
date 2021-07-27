package com.itheima.health.dao;

import com.github.pagehelper.Page;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: Eric
 * @since: 2020/11/21
 */
public interface CheckItemDao {

    /**
     * 查询所有的检查项
     * @return
     */
    List<CheckItem> findAll();

    /**
     * 添加检查项
     * @param checkItem
     */
    void add(CheckItem checkItem);

    /**
     * 条件查询
     * @param queryString
     * @return
     */


    /**
     * 通过id查询
     * @param id
     * @return
     */
    CheckItem findById(int id);

    /**
     * 更新
     * @param checkItem
     */
    void update(CheckItem checkItem);

    /**
     * 通过检查项id查询是否被检查组使用
     * @param id
     * @return
     */
    int findCountByCheckItemId(int id);

    /**
     * 通过id删除
     * @param id
     */
    void deleteById(int id);

    Page findpage(QueryPageBean queryPageBean);
}
