package cn.lht.controller;

import cn.lht.entity.BsBookclass;
import cn.lht.service.BsBookclassService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (BsBookclass)表控制层
 *
 * @author makejava
 * @since 2020-02-24 16:09:51
 */
@RestController
@RequestMapping("bsBookclass")
public class BsBookclassController {
    /**
     * 服务对象
     */
    @Resource
    private BsBookclassService bsBookclassService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsBookclass selectOne(Object id) {
        return this.bsBookclassService.queryById(id);
    }

}