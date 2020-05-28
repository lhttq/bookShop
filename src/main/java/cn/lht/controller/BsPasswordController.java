package cn.lht.controller;

import cn.lht.ThreadLocal.RegisterThreadLocal;
import cn.lht.entity.BsPassword;
import cn.lht.service.BsPasswordService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BsPassword)表控制层
 *
 * @author makejava
 * @since 2020-02-24 16:10:47
 */
@Controller
@RequestMapping("bsPassword")
public class BsPasswordController {
    /**
     * 服务对象
     */
    @Resource
    private BsPasswordService bsPasswordService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public BsPassword selectOne(Object id) {
        return this.bsPasswordService.queryById(id);
    }

    /**
     * 注册
     * @return
     */
    @PostMapping("InsertUser")
    public String InsertUser(){
        BsPassword bsPassword = RegisterThreadLocal.get();
        System.out.println(bsPassword.getBsLastloginip());
        bsPasswordService.insert(bsPassword);
        return "login";
    }
    /**
     *
     * @return
     */
    @RequestMapping("QueryByLoginName")
    public String QueryByLoginName(){
        return null;
    }

     @RequestMapping("QueryByLoginName1")
     @ResponseBody
    public List<BsPassword> QueryByLoginName1(@RequestBody BsPassword bsPassword){
         List<BsPassword> list = this.bsPasswordService.queryAll(bsPassword);
        return list;
    }

    /**
     * 修改密码
     *
     * @param bsPassword 实例对象
     * @return 影响行数
     */
    @RequestMapping("updateByLogiName")
    @ResponseBody
    public Integer updateByLogiName(@RequestBody BsPassword bsPassword){
        List<BsPassword> bsPasswordList = this.bsPasswordService.queryAll(bsPassword);
        BsPassword bsPassword1 = bsPasswordList.get(0);
        bsPassword1.setBsPassword(bsPassword.getBsPassword());
        return this.bsPasswordService.update(bsPassword1);
    }
    /**
     * 跳转
     *
     * @return 字符串
     */
     @RequestMapping("Skip")
    public String Skip(){
        return "fpassword";
    }
    /**
     * 跳转
     *
     * @return 字符串
     */
     @RequestMapping("Skip1")
    public String Skip1(){
        return "password2";
    }
     /**
     * 跳转
     *
     * @return 字符串
     */
     @RequestMapping("Skip2")
    public String Skip2(){
        return "password3";
    }
}