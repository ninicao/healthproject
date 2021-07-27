package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.health.Exception.MyException;
import com.itheima.health.dao.CheckItemDao;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * interfaceClass: 指定发布的服务接口
 * 在dubbo:2.6.0里使用事务时，需要指定
 * </p>
 *
 * @author: Eric
 * @since: 2020/11/21
 */
@Service(interfaceClass = CheckItemService.class)
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemDao checkItemDao;

    @Override
    public List<CheckItem> findAll() {
        return checkItemDao.findAll();
    }

    /**
     * 添加检查项
     * @param checkItem
     */
    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    /**
     * 分页条件查询
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult findpage(QueryPageBean queryPageBean) {
        PageHelper.startPage(queryPageBean.getCurrentPage(),queryPageBean.getPageSize());
        if(!queryPageBean.getQueryString().isEmpty()){

        }


        return null;
    }


    @Override
    public CheckItem findById(int id) {
        return checkItemDao.findById(id);
    }

    /**
     * 更新
     * @param checkItem
     */
    @Override
    public void update(CheckItem checkItem) {
        checkItemDao.update(checkItem);
    }

    /**
     * 通过id删除
     * @param id
     */
    @Override
    public void deleteById(int id) {
        // 判断 是否被检查组使用了
        int count = checkItemDao.findCountByCheckItemId(id);
        // count > 0 被使用了，报错
        if(count > 0){
            throw new MyException("该检查项被检查组使用了，不能删除");
        }
        // =0，则可以删除
        checkItemDao.deleteById(id);
    }


}
