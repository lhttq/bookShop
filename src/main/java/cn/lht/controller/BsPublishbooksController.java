package cn.lht.controller;

import cn.lht.ThreadLocal.BsPublishBooksThreadLocal;
import cn.lht.entity.BsPublishbooks;
import cn.lht.service.BsPublishbooksService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * (BsPublishbooks)表控制层
 *
 * @author makejava
 * @since 2020-04-02 16:12:48
 */
@Controller
@RequestMapping("bsPublishbooks")
public class BsPublishbooksController {
    /**
     * 服务对象
     */
    @Resource
    private BsPublishbooksService bsPublishbooksService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @RequestMapping("selectOne")
    public BsPublishbooks selectOne(Integer id) {
        return this.bsPublishbooksService.queryById(id);
    }

    /**
     * 录入书籍
     *
     * @param bsPublishbooks 实例对象
     * @return 影响行数
     * @throws ParseException
     */
    @RequestMapping("InsertBook")
    @ResponseBody
    public Integer InsertBook(@RequestBody BsPublishbooks bsPublishbooks) throws ParseException {
        //格式化时间
            //定义SimpleDateFormat对象，指定要格式化的时间格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            //获取对象中的时间，并将其修改为指定号格式的字符串
        String createTime = simpleDateFormat.format(bsPublishbooks.getBsCratetime());
            //将字符串类型的时间转换为date类型的时间
        Date date = simpleDateFormat.parse(createTime);
            //转换时间类型为 java.sql.Date
        java.sql.Date resultDate = new java.sql.Date(date.getTime());
                //将转化好的时间格式重新放入对象中
        bsPublishbooks.setBsCratetime(resultDate);
        //插入数据
        return this.bsPublishbooksService.insert(bsPublishbooks);
    }

    /**
     * 查询全部书籍
     *
     * @param model
     * @return
     */
    @RequestMapping("SelectByBsPublish")
    public String SelectByBsPublish(Model model){
        BsPublishbooks bsPublishbooks = BsPublishBooksThreadLocal.get();
        List<BsPublishbooks> list = bsPublishbooksService.queryAllByBsPublish(bsPublishbooks);
        model.addAttribute("list",list);
        return "examineBook";
    }

    /**
     * 更新书籍信息
     *
     * @param bsPublishbooks
     * @return
     */
    @RequestMapping("UpdateBsPublishbook")
    @ResponseBody
    public Integer UpdateBsPublishbook(@RequestBody BsPublishbooks bsPublishbooks){
        System.out.println(bsPublishbooks.toString());
        BsPublishbooks bsPublishbooks1 =
                this.bsPublishbooksService.queryById(bsPublishbooks.getBsBooksid());
        if(bsPublishbooks1.getBsBooknum()>0){
            bsPublishbooks1.setBsBooknum(bsPublishbooks1.getBsBooknum() - 1);
        }
        return  this.bsPublishbooksService.update(bsPublishbooks1);
    }
}