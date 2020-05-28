package cn.lht.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BsAdmin)实体类
 *
 * @author makejava
 * @since 2020-02-24 16:09:09
 */
public class BsAdmin implements Serializable {
    private static final long serialVersionUID = 602356556472655441L;
    /**
    * 管理员id
    */
    private Integer bsAdminid;
    /**
    * 管理员账号
    */
    private String bsAdminlogin;
    /**
    * 管理员密码
    */
    private String bsAdminpass;
    /**
    * 职工编号
    */
    private String bsAdminnum;
    /**
    * 创建时间
    */
    private Date bsCreatetime;
    /**
    * 最后登陆时间
    */
    private Date bsLatelogintime;
    /**
    * 最后登录IP
    */
    private String bsLatelateip;


    public Integer getBsAdminid() {
        return bsAdminid;
    }

    public void setBsAdminid(Integer bsAdminid) {
        this.bsAdminid = bsAdminid;
    }

    public String getBsAdminlogin() {
        return bsAdminlogin;
    }

    public void setBsAdminlogin(String bsAdminlogin) {
        this.bsAdminlogin = bsAdminlogin;
    }

    public String getBsAdminpass() {
        return bsAdminpass;
    }

    public void setBsAdminpass(String bsAdminpass) {
        this.bsAdminpass = bsAdminpass;
    }

    public String getBsAdminnum() {
        return bsAdminnum;
    }

    public void setBsAdminnum(String bsAdminnum) {
        this.bsAdminnum = bsAdminnum;
    }

    public Date getBsCreatetime() {
        return bsCreatetime;
    }

    public void setBsCreatetime(Date bsCreatetime) {
        this.bsCreatetime = bsCreatetime;
    }

    public Date getBsLatelogintime() {
        return bsLatelogintime;
    }

    public void setBsLatelogintime(Date bsLatelogintime) {
        this.bsLatelogintime = bsLatelogintime;
    }

    public String getBsLatelateip() {
        return bsLatelateip;
    }

    public void setBsLatelateip(String bsLatelateip) {
        this.bsLatelateip = bsLatelateip;
    }

}