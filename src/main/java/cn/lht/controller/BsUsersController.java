package cn.lht.controller;

import cn.lht.entity.BsUsers;
import cn.lht.service.BsUsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * (BsUsers)表控制层
 *
 * @author makejava
 * @since 2020-02-24 16:11:18
 */
@Controller
@RequestMapping("bsUsers")
public class BsUsersController {
    /**
     * 服务对象
     */
    @Resource
    private BsUsersService bsUsersService;

    /**
     *  查询单条数据
     *
     * @param bsLoginname 用户名
     * @param model model对象
     * @return 字符串
     */
    @RequestMapping("SelectByUserLoginName")
    public String SelectByUserLoginName(@RequestParam("bsLoginname") String bsLoginname,
                                        Model model){
        System.out.println(bsLoginname);
        BsUsers bsUsers = new BsUsers();
        bsUsers = bsUsersService.queryByBsLoginName(bsLoginname);
        if(bsUsers != null){
            System.out.println(bsUsers.toString());
            model.addAttribute("bsUsers",bsUsers);
        }
        return "info";
    }

    /**
     * 根据用户名查询用户信息
     *
     * @param bsUsers 实例对象
     * @return 实例对象
     */
    @RequestMapping("SelectByUserLoginName1")
    @ResponseBody
    public BsUsers SelectByUserLoginName1(@RequestBody BsUsers bsUsers) {
        BsUsers bsUsers1 = new BsUsers();
       bsUsers = this.bsUsersService.queryByBsLoginName(bsUsers.getBsLoginname());
        return bsUsers;
    }

    /**
     *添加用户信息、修改用户信息
     *
     * @param bsUsers 实例对象
     * @return 影响行数
     * @throws ParseException
     */
    @PostMapping("InsertUser")
    @ResponseBody
    public Integer InsertUser(@RequestBody BsUsers bsUsers) throws ParseException {
        //定义返回值，返回0,提示用户添加或修改信息失败，返回1，提示用户添加或修改数据成功
        Integer i = 0;
        //格式化时间，将时间转换为指定格式
                //定义SimpleDateFormat对象，指定时间转换格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                //将用户提交的时间转换为上面定义的格式的字符串形式
        String createTime = simpleDateFormat.format(bsUsers.getBsUserbrithday());
                //将上面字符串形式的时间转换为Date类型的时间格式
        Date date = simpleDateFormat.parse(createTime);
                //将java时间类型转换为sql时间类型
        java.sql.Date resultDate = new java.sql.Date(date.getTime());
                //重新将时间放入user对象中
        bsUsers.setBsUserbrithday(resultDate);
        //根据账号查询用户信息
        BsUsers bsUsers1 = bsUsersService.queryByBsLoginName(bsUsers.getBsLoginname());
        //如果用户不存在添加用户信息，如果用户存在，修改用户信息
        if(bsUsers1 == null) {
            //如将用户信息插入数据库，并返回影响行数信息
            i = bsUsersService.insert(bsUsers);
        }else{
            //用户存在，修改用户信息，并返回影响行数信息
            bsUsers.setBsUserid(bsUsers1.getBsUserid());
            i = bsUsersService.update(bsUsers);
        }
        return i;
    }

    /**
     * 跳转到信息页
     *
     * @return 字符串
     */
    @RequestMapping("Select")
    public String Select(){
        return "info";
    }

    /**
     *  跳转页面用
     *
     * @return 空
     */
    @RequestMapping("Skip")
    public String Skip(){
        return null;
    }
}