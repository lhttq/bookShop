package cn.lht.controller;

import cn.lht.ThreadLocal.CartsThreadLocal;
import cn.lht.entity.BsBookclass;
import cn.lht.entity.BsBooks;
import cn.lht.entity.BsCarts;
import cn.lht.entity.BsPress;
import cn.lht.service.BsBookclassService;
import cn.lht.service.BsBooksService;
import cn.lht.service.BsCartsService;
import cn.lht.service.BsPressService;
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
 * (BsCarts)表控制层
 *
 * @author makejava
 * @since 2020-03-03 20:53:54
 */
@Controller
@RequestMapping("bsCarts")
public class BsCartsController {
    /**
     * 服务对象
     */
    @Resource
    private BsCartsService bsCartsService;
    @Resource
    private BsBooksService bsBooksService;
    @Resource
    private BsBookclassService bsBookclassService;
    @Resource
    private BsPressService bsPressService;
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsCarts selectOne(Integer id) {
        return this.bsCartsService.queryById(id);
    }

    /**
     * 添加购物车书籍
     *
     * @param bsCarts 实例对象
     * @return 影响行数
     */
    @RequestMapping("InsertBsCart")
    @ResponseBody
    public Integer InsertBsCart(@RequestBody BsCarts bsCarts){
        Integer i = -1;
        //根据用户ID和书籍ID查询书籍购物车中是否存在该数据，如果存在数量加一，不存在添加数据
        //定义两个对象当做中转变量
        BsCarts bsCarts1 = new BsCarts();
        BsCarts bsCarts2 = new BsCarts();
        //获取传入数据的物品Id
        bsCarts1.setBsGoodsid(bsCarts.getBsGoodsid());
        //获取传入数据的用户Id
        bsCarts1.setBsUserid(bsCarts.getBsUserid());
        //查询购物车书籍是否存在
        List<BsCarts> bsCartsList =  bsCartsService.queryAll(bsCarts1);
        //如果购物侧中不存在该书籍，则将该书籍添加到购物车
        if(bsCartsList.size() == 0){
            //将书籍添加到购物车列表中
            this.bsCartsService.insert(bsCarts);
        }else{
            //如果购物车中存在该书籍，书籍数量加一
                //将查到的书籍信息存入中间变量中
            bsCarts2 = bsCartsList.get(0);
                //将书籍数量加一
            bsCarts2.setBsCartnum(bsCarts2.getBsCartnum() + 1);
                //将加一后的书籍信息存入数据库
            i = this.bsCartsService.update(bsCarts2);
        }
        return i;
    }

    /**
     *查看购物车信息
     *
     * @param model
     * @return 对象列表
     */
    @RequestMapping("SelectAllByUserId")
    public String SelectAllByUserId(Model model){
       BsCarts bsCarts = CartsThreadLocal.get();
       //创建购物车集合
       List<BsCarts> bsCartsList =  bsCartsService.queryAll(bsCarts);
        //创建图书集合
        List<BsBooks> bsBooksList = new ArrayList<BsBooks>();
        //创建图书类别集合
        List<BsBookclass> bsBookclassList = new ArrayList<BsBookclass>();
        //创建出版社集合
        List<BsPress> bsPressList = new ArrayList<BsPress>();
        for (BsCarts b : bsCartsList) {
            System.out.println( "物品id:"+b.getBsGoodsid());
            bsBooksList.add(bsBooksService.queryById(b.getBsGoodsid()));
        }
        //通过类别编号查出类别名称
        //通过出版社编号查出出版社信息
        for (BsBooks b: bsBooksList) {
            System.out.println("书籍作者："+b.getBsBookauthor());
            bsBookclassList.add(bsBookclassService.queryById(b.getBsBookclassid()));
            bsPressList.add(bsPressService.queryByNum(b.getBsPressnum()));
        }
        model.addAttribute("bsCartsList",bsCartsList);
        model.addAttribute("bsBooksList",bsBooksList);
        model.addAttribute("bsBookclassList",bsBookclassList);
        model.addAttribute("bsPressList",bsPressList);
        return "carts";
    }

    /**
     *
     * @param model
     * @return
     */
    @RequestMapping("SelectAllByIs")
    public String SelectAllByIs(Model model){
        BsCarts bsCarts = CartsThreadLocal.get();
        //新建购物车List
        List<BsCarts> bsCartsList = new ArrayList<BsCarts>();
         //新建图书List
        List<BsBooks> bsBooksList = new ArrayList<BsBooks>();
         //新建出版社List
        List<BsPress> bsPressList = new ArrayList<BsPress>();
         //新建List
        bsCartsList = bsCartsService.queryAll(bsCarts);
        for (BsCarts b:bsCartsList) {
               bsBooksList.add(bsBooksService.queryById(b.getBsGoodsid()));
        }
        for(BsBooks b:bsBooksList){
            bsPressList.add(bsPressService.queryByNum(b.getBsPressnum()));
        }
        model.addAttribute("bsCartsList",bsCartsList);
        model.addAttribute("bsBooksList",bsBooksList);
        model.addAttribute("bsPressList",bsPressList);
        return "order";
    }
    /**
     *修改购物车
     *
     * @param bsCarts 实例对象
     * @return 影响行数
     */
     @RequestMapping("UpdateNum")
     @ResponseBody
    public Integer UpdateNum(@RequestBody BsCarts bsCarts){
         System.out.println(bsCarts);
        return bsCartsService.update(bsCarts);
    }
    /**
     *
     * @param bsCarts 实例对象
     * @return 影响行数
     */
    @RequestMapping("DelByBookidandUserId")
    @ResponseBody
    public Boolean DelByBookidandUserId(@RequestBody BsCarts bsCarts){
        return bsCartsService.deleteByUseridAndBookid(bsCarts);
    }
}