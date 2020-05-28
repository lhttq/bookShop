package cn.lht.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BsPassword)实体类
 *
 * @author makejava
 * @since 2020-02-24 16:10:47
 */
public class BsPassword implements Serializable {
    private static final long serialVersionUID = 563794270478968908L;
    /**
    * 自增id
    */
    private Integer bsUserid;
    /**
    * 账号
    */
    private String bsLoginname;
    /**
    * 密码
    */
    private String bsPassword;
    /**
    * 支付密码
    */
    private String bsPaypassword;
    /**
    * 创建时间
    */
    private Date bsCreatetime;
    /**
    * 最后登录时间
    */
    private Date bsLastlogintime;
    /**
    * 最后登录IP
    */
    private String bsLastloginip;


    public Integer getBsUserid() {
        return bsUserid;
    }

    public void setBsUserid(Integer bsUserid) {
        this.bsUserid = bsUserid;
    }

    public String getBsLoginname() {
        return bsLoginname;
    }

    public void setBsLoginname(String bsLoginname) {
        this.bsLoginname = bsLoginname;
    }

    public String getBsPassword() {
        return bsPassword;
    }

    public void setBsPassword(String bsPassword) {
        this.bsPassword = bsPassword;
    }

    public String getBsPaypassword() {
        return bsPaypassword;
    }

    public void setBsPaypassword(String bsPaypassword) {
        this.bsPaypassword = bsPaypassword;
    }

    public Date getBsCreatetime() {
        return bsCreatetime;
    }

    public void setBsCreatetime(Date bsCreatetime) {
        this.bsCreatetime = bsCreatetime;
    }

    public Date getBsLastlogintime() {
        return bsLastlogintime;
    }

    public void setBsLastlogintime(Date bsLastlogintime) {
        this.bsLastlogintime = bsLastlogintime;
    }

    public String getBsLastloginip() {
        return bsLastloginip;
    }

    public void setBsLastloginip(String bsLastloginip) {
        this.bsLastloginip = bsLastloginip;
    }

}