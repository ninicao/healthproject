package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.constant.MessageConstant;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckGroup;
import com.itheima.health.service.CheckGroupService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author: Eric
 * @since: 2020/11/22
 */
@RestController
@RequestMapping("/checkgroup")
public class CheckGroupController {

    @Reference
    private CheckGroupService checkGroupService;

    /**
     * 添加检查组
     * @param checkGroup
     * @param checkitemIds
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        // 调用服务添加检查组
        checkGroupService.add(checkGroup,checkitemIds);
        return new Result(true, MessageConstant.ADD_CHECKGROUP_SUCCESS);
    }

    /**
     * 分页条件查询
     */
    @PostMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
        // 调用服务查询
        PageResult<CheckGroup> pageResult = checkGroupService.findPage(queryPageBean);
        return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,pageResult);
    }

    /**
     * 通过id查询
     */
    @GetMapping("/findById")
    public Result findById(int id){
        CheckGroup checkGroup = checkGroupService.findById(id);
        return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkGroup);
    }

    /**
     * 通过id查询选中的检查项id集合
     */
    @GetMapping("/findCheckItemIdsByCheckGroupId")
    public Result findCheckItemIdsByCheckGroupId(int id){
        List<Integer> checkItemIds = checkGroupService.findCheckItemIdsByCheckGroupId(id);
        return new Result(true, MessageConstant.QUERY_CHECKGROUP_SUCCESS,checkItemIds);
    }

    /**
     * 修改检查组
     * @param checkGroup
     * @param checkitemIds
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody CheckGroup checkGroup,Integer[] checkitemIds){
        // 调用服务更新检查组
        checkGroupService.update(checkGroup,checkitemIds);
        return new Result(true, MessageConstant.EDIT_CHECKGROUP_SUCCESS);
    }

    /**
     * 通过id删除检查组
     */
    @PostMapping("/deleteById")
    public Result deleteById(int id){
        // 调用服务删除
        checkGroupService.deleteById(id);
        return new Result(true, MessageConstant.DELETE_CHECKGROUP_SUCCESS);
    }
}
