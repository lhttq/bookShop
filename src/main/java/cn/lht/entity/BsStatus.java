package cn.lht.entity;

import java.io.Serializable;

/**
 * (BsStatus)实体类
 *
 * @author makejava
 * @since 2020-02-24 16:11:09
 */
public class BsStatus implements Serializable {
    private static final long serialVersionUID = -96330390135915073L;
    /**
    * 自增Id
    */
    private Integer bsUserid;
    /**
    * 账号
    */
    private String bsLoginname;
    /**
    * 最后登录IP
    */
    private String bsLastip;
    /**
    * 最后登录时间
    */
    private Object bsLasttime;
    /**
    * 账号状态：0停用，1启用
    */
    private Object bsUserstatus;
    /**
    * 删除标志：1有效，-1无效
    */
    private Object bsDataflag;
    /**
    * 创建时间
    */
    private Object bsCreatetime;


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

    public String getBsLastip() {
        return bsLastip;
    }

    public void setBsLastip(String bsLastip) {
        this.bsLastip = bsLastip;
    }

    public Object getBsLasttime() {
        return bsLasttime;
    }

    public void setBsLasttime(Object bsLasttime) {
        this.bsLasttime = bsLasttime;
    }

    public Object getBsUserstatus() {
        return bsUserstatus;
    }

    public void setBsUserstatus(Object bsUserstatus) {
        this.bsUserstatus = bsUserstatus;
    }

    public Object getBsDataflag() {
        return bsDataflag;
    }

    public void setBsDataflag(Object bsDataflag) {
        this.bsDataflag = bsDataflag;
    }

    public Object getBsCreatetime() {
        return bsCreatetime;
    }

    public void setBsCreatetime(Object bsCreatetime) {
        this.bsCreatetime = bsCreatetime;
    }

}