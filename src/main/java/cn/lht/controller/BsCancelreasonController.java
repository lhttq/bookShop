package cn.lht.controller;

import cn.lht.entity.BsCancelreason;
import cn.lht.service.BsCancelreasonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (BsCancelreason)表控制层
 *
 * @author makejava
 * @since 2020-02-24 16:10:27
 */
@RestController
@RequestMapping("bsCancelreason")
public class BsCancelreasonController {
    /**
     * 服务对象
     */
    @Resource
    private BsCancelreasonService bsCancelreasonService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsCancelreason selectOne(Integer id) {
        return this.bsCancelreasonService.queryById(id);
    }

}