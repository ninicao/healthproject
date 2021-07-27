package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.constant.MessageConstant;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import org.springframework.web.bind.annotation.*;
import sun.plugin2.message.Message;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: Eric
 * @since: 2020/11/21
 */
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {

    @Reference
    private CheckItemService checkItemService;

    /**
     * 查询所有检查项
     * @return
     */
    @GetMapping("/findAll")
    public Result findAll(){
        List<CheckItem> list = checkItemService.findAll();
        // 封装到result
        return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,list);
    }

    /**
     * 添加检查项
     */
    @PostMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){
        // 调用服务添加
        checkItemService.add(checkItem);
        // 返回结果
        return new Result(true, MessageConstant.ADD_CHECKITEM_SUCCESS);
    }

    /**
     * 分页条件查询
     */
    @PostMapping("/findPage")
    public Result findPage(QueryPageBean queryPageBean){
          PageResult pageResult =  checkItemService.findpage(queryPageBean);

        return new Result(true,MessageConstant.QUERY_CHECKGROUP_SUCCESS,pageResult);
    }


    /**
     * 通过id查询
     */
    @GetMapping("/findById")
    public Result findById(int id){
        CheckItem checkItem = checkItemService.findById(id);
        return new Result(true, MessageConstant.QUERY_CHECKITEM_SUCCESS,checkItem);
    }

    /**
     * 更新
     */
    @PostMapping("/update")
    public Result update(@RequestBody CheckItem checkItem){
        // 调用服务修改
        checkItemService.update(checkItem);
        // 返回结果
        return new Result(true, MessageConstant.EDIT_CHECKITEM_SUCCESS);
    }

    /**
     * 删除
     */
    @PostMapping("/deleteById")
    public Result deleteById(int id){
        checkItemService.deleteById(id);
        return new Result(true, MessageConstant.DELETE_CHECKITEM_SUCCESS);
    }
}
