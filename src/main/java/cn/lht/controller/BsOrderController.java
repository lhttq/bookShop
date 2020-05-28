package cn.lht.controller;

import cn.lht.ThreadLocal.OrderIhreadLocal;
import cn.lht.entity.BsAddress;
import cn.lht.entity.BsOrder;
import cn.lht.entity.BsOrderbooks;
import cn.lht.service.BsAddressService;
import cn.lht.service.BsOrderService;
import cn.lht.service.BsOrderbooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (BsOrder)表控制层
 *
 * @author makejava
 * @since 2020-04-13 15:55:14
 */
@Controller
@RequestMapping("bsOrder")
public class BsOrderController {
    /**
     * 服务对象
     */
    @Resource
    private BsOrderService bsOrderService;
    /**
     * 服务对象
     */
    @Resource
    private BsAddressService bsAddressService;
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
    public BsOrder selectOne(Integer id) {
        return this.bsOrderService.queryById(id);
    }

    /**
     * 插入订单
     *
     * @param bsOrder 实例对象
     * @return 影响行数
     */
    @RequestMapping("insertOne")
    @ResponseBody
    public List<BsOrder> insertOne(@RequestBody BsOrder bsOrder){
        bsOrder.toString();
        Integer index = Integer.parseInt(bsOrder.getBsUsername());
        BsAddress bsAddress = new BsAddress();
        bsAddress.setBsUserid(bsOrder.getBsUserid());
        List<BsAddress> bsAddressList =  this.bsAddressService.queryByUserId(bsAddress);
        bsAddress = bsAddressList.get(index);
        bsOrder.setBsUsername(bsAddress.getBsUsername());
        bsOrder.setBsUserphone(bsAddress.getBsUserphone());
        bsOrder.setBsUseraddress(bsAddress.getBsAreaidpath());
        this.bsOrderService.insert(bsOrder);
        BsOrder bsOrder1 = new BsOrder();
        bsOrder1.setBsOrderno(bsOrder.getBsOrderno());
        List<BsOrder> bsOrderList = this.bsOrderService.queryAll(bsOrder1);
        return bsOrderList;
    }

    /**
     * 页面跳转-我的订单
     * @return
     */
    @RequestMapping("selectByUserId")
     public String selectByUserId(Model model){
        //获取订单对象
        BsOrder bsOrder = OrderIhreadLocal.get();
        bsOrder.toString();
        List<BsOrder> bsOrderList = this.bsOrderService.queryAll(bsOrder);
        List<List<BsOrderbooks>> lists = new ArrayList<List<BsOrderbooks>>();
        BsOrderbooks bsOrderbooks = new BsOrderbooks();
        for (BsOrder b:bsOrderList) {
            bsOrderbooks.setBsOrderid(b.getBsOrderid());
            List<BsOrderbooks> bsOrderbooksList =
                    this.bsOrderbooksService.queryAll(bsOrderbooks);
            lists.add(bsOrderbooksList);
        }
        model.addAttribute("bsOrderList",bsOrderList);
        model.addAttribute("lists",lists);
        return "myorder";
     }
}