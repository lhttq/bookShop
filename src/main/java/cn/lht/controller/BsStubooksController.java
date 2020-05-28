package cn.lht.controller;

import cn.lht.ThreadLocal.StuBooksThreadLocal;
import cn.lht.entity.BsStubooks;
import cn.lht.service.BsStubooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsStubooks)表控制层
 *
 * @author makejava
 * @since 2020-04-01 20:49:56
 */
@Controller
@RequestMapping("bsStubooks")
public class BsStubooksController {
    /**
     * 服务对象
     */
    @Resource
    private BsStubooksService bsStubooksService;

    /**
     * 通过主键查询单条数据
     *
     * @param bsBookid 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public String selectOne(@RequestParam Integer bsBookid, Model model) {
        BsStubooks bsStubooks = this.bsStubooksService.queryById(bsBookid);
        model.addAttribute("bsStubooks",bsStubooks);
        return "Stushow";
    }

    /**
     * 用于跳转使用
     *
     * @return
     */
    @RequestMapping("skip")
    public Integer skip(){
        return null;
    }
    /**
     * 通过学校查询书籍
     *
     * @param model 数据对象
     * @return 页面
     */
    @RequestMapping("selectPyUniversity")
    public String selectPyUniversity(Model model){
        BsStubooks bsStubooks = StuBooksThreadLocal.get();
        List<BsStubooks> list = this.bsStubooksService.queryAllByUniversity(bsStubooks);
        model.addAttribute("list",list);
        return "BsStuBooksList";
    }

    /**
     * 查询
     *
     * @param model
     * @return 字符串
     */
     @RequestMapping("selectPyUniversity2")
    public String selectPyUniversity1(Model model){
        BsStubooks bsStubooks = StuBooksThreadLocal.get();
        List<BsStubooks> list = this.bsStubooksService.queryAllByUniversity(bsStubooks);
        model.addAttribute("list",list);
        return "MyStuSellBook";
    }
    /**
     *
     * @param bsStubooks 实例对象
     * @return 对象列表
     */
    @RequestMapping("selectPyUniversity1")
    @ResponseBody
    public List selectPyUniversity1(@RequestBody BsStubooks bsStubooks){
        String bookName = bsStubooks.getBsBookname();
        bookName = "%" + bookName +"%";
        bsStubooks.setBsBookname(bookName);
        List<BsStubooks> list = this.bsStubooksService.queryAllByUniversity(bsStubooks);
        return list;
    }

    /**
     * 新增书籍
     *
     * @param bsStubooks 实例对象
     * @return 影响行数
     */
    @RequestMapping("InsertBook")
    @ResponseBody
    public Integer InsertBook(@RequestBody BsStubooks bsStubooks){
        return this.bsStubooksService.insert(bsStubooks);
    }

    /**
     * 更新信息
     *
     * @param bsStubooks 实例对象
     * @return 影响行数
     */
    @RequestMapping("UpdateStuBook")
    @ResponseBody
    public Integer UpdateStuBook(@RequestBody BsStubooks bsStubooks){
        System.out.println(bsStubooks);
        BsStubooks bsStubooks1 = this.bsStubooksService.queryById(bsStubooks.getBsBookid());
        if(bsStubooks1.getBsBooknum() > 0){
            bsStubooks1.setBsBooknum(bsStubooks1.getBsBooknum() - 1);
            bsStubooks1.setBsBuylogin(bsStubooks.getBsBuylogin());
            System.out.println(bsStubooks1.toString());
        }
        return this.bsStubooksService.update(bsStubooks1);
    }
}