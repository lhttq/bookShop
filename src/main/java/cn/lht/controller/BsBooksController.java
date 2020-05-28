package cn.lht.controller;

import cn.lht.ThreadLocal.BooksThreadLocal;
import cn.lht.entity.BsBooks;
import cn.lht.service.BsBooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsBooks)表控制层
 *
 * @author makejava
 * @since 2020-02-26 19:24:25
 */
@Controller
@RequestMapping("bsBooks")
public class BsBooksController {
    /**
     * 服务对象
     */
    @Resource
    private BsBooksService bsBooksService;
    /**
     * 通过主键查询单条数据
     * @param bsBookid 主键
     * @return 单条数据
     */
    @RequestMapping(value = "selectOne")
    public  String  selectOne(@RequestParam Integer bsBookid, Model model) {
        System.out.println("我执行了");
        System.out.println(bsBookid);
        BsBooks bsBooks = bsBooksService.queryById(bsBookid);
        model.addAttribute("bsBooks",bsBooks);
        return "show";
    }

    /**
     * 搜索书籍
     * @param model
     * @return
     */
    @RequestMapping("selectM")
    public String selectM(Model model){
        BsBooks bsBooks =  BooksThreadLocal.get();
        List<BsBooks> list = bsBooksService.queryAll(bsBooks);
        String bsBookname = bsBooks.getBsBookname();
        model.addAttribute("bsBookname",bsBookname);
        model.addAttribute("list",list);
        return "list";
    }
    @GetMapping("selectM1")
    @ResponseBody
    public List selectM1(@RequestParam("bsBookname") String bsBookname){
        System.out.println("我执行了");
        BsBooks bsBooks = new BsBooks();
        String bsBookname1 = "%" + bsBookname + "%";
        bsBooks.setBsBookname(bsBookname1);
        List<BsBooks> list = bsBooksService.queryAll(bsBooks);
        return list;
    }
    @GetMapping("queryAllByLimit")
    @ResponseBody
    public List queryAllByLimit(@RequestParam("ids[]") int[] ids ){
        return bsBooksService.queryAllByLimit(ids[0],ids[1]);
    }
}