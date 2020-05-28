package cn.lht.controller;

import cn.lht.entity.BsAddress;
import cn.lht.service.BsAddressService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsAddress)表控制层
 *
 * @author makejava
 * @since 2020-03-28 21:34:48
 */
@Controller
@RequestMapping("bsAddress")
public class BsAddressController {
    /**
     * 服务对象
     */
    @Resource
    private BsAddressService bsAddressService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsAddress selectOne(Integer id) {
        return this.bsAddressService.queryById(id);
    }

    /**
     * 插入数据
     *
     * @param bsAddress 实例对象
     * @return 实例对象
     */
    @RequestMapping("insertPyentity")
    @ResponseBody
    public BsAddress insertPyentity(@RequestBody BsAddress bsAddress){
        return this.bsAddressService.insert(bsAddress);
    }

    /**
     *
     * @param bsAddress 实例对象
     * @return 对象列表
     */
    @RequestMapping("selectByUserId")
    @ResponseBody
    public List<BsAddress> selectByUserId(@RequestBody BsAddress bsAddress){
        List<BsAddress> list = this.bsAddressService.queryByUserId(bsAddress);
        return list;
    }

}