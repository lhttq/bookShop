package cn.lht.controller;

import cn.lht.entity.BsPress;
import cn.lht.service.BsPressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * (BsPress)表控制层
 *
 * @author makejava
 * @since 2020-02-21 22:46:24
 */
@Controller
@RequestMapping("/bsPress")
public class BsPressController {
    /**
     * 服务对象
     */
    @Resource
    private BsPressService bsPressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public @ResponseBody
    BsPress selectOne(Integer id) {
        return this.bsPressService.queryById(id);
    }
    //@GetMapping("findAll")
    @RequestMapping("/findAll")
    public @ResponseBody
    BsPress findAll(@RequestBody BsPress bsPress){
        System.out.println("我执行了");
        System.out.println(bsPress.getBsPressname());
        System.out.println(bsPress.getBsPressnum());
        bsPress = bsPressService.queryById(1);
        return bsPress;
    }

}