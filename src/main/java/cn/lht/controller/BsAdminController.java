package cn.lht.controller;


import cn.lht.entity.BsAdmin;
import cn.lht.service.BsAdminService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (BsAdmin)表控制层
 *
 * @author makejava
 * @since 2020-02-24 16:09:15
 */
@RestController
@RequestMapping("bsAdmin")
public class BsAdminController {
    /**
     * 服务对象
     */
    @Resource
    private BsAdminService bsAdminService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsAdmin selectOne(Integer id) {
        return this.bsAdminService.queryById(id);
    }

}