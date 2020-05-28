package cn.lht.controller;

import cn.lht.entity.BsRejectreason;
import cn.lht.service.BsRejectreasonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (BsRejectreason)表控制层
 *
 * @author makejava
 * @since 2020-02-24 16:10:58
 */
@RestController
@RequestMapping("bsRejectreason")
public class BsRejectreasonController {
    /**
     * 服务对象
     */
    @Resource
    private BsRejectreasonService bsRejectreasonService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsRejectreason selectOne(Integer id) {
        return this.bsRejectreasonService.queryById(id);
    }

}