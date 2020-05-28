package cn.lht.controller;

import cn.lht.entity.BsStatus;
import cn.lht.service.BsStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (BsStatus)表控制层
 *
 * @author makejava
 * @since 2020-02-24 16:11:09
 */
@RestController
@RequestMapping("bsStatus")
public class BsStatusController {
    /**
     * 服务对象
     */
    @Resource
    private BsStatusService bsStatusService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsStatus selectOne(Integer id) {
        return this.bsStatusService.queryById(id);
    }

}