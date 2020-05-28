package cn.lht.controller;

import cn.lht.entity.BsOrderbooks;
import cn.lht.service.BsOrderbooksService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (BsOrderbooks)表控制层
 *
 * @author makejava
 * @since 2020-04-13 16:02:43
 */
@RestController
@RequestMapping("bsOrderbooks")
public class BsOrderbooksController {
    /**
     * 服务对象
     */
    @Resource
    private BsOrderbooksService bsOrderbooksService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsOrderbooks selectOne(Integer id) {
        return this.bsOrderbooksService.queryById(id);
    }

    /**
     * 插入一条数据
     *
     * @param bsOrderbooks 实例对象
     * @return 影响行数
     */
   @RequestMapping("insertOne")
    @ResponseBody
    public Integer insertOne(@RequestBody BsOrderbooks bsOrderbooks){
        return this.bsOrderbooksService.insert(bsOrderbooks);
    }
}