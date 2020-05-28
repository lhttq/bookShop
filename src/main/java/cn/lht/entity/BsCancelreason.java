package cn.lht.entity;

import java.io.Serializable;

/**
 * (BsCancelreason)实体类
 *
 * @author makejava
 * @since 2020-02-24 16:10:27
 */
public class BsCancelreason implements Serializable {
    private static final long serialVersionUID = -20709501307032025L;
    /**
    * 取消原因Id
    */
    private Integer bsCancelreasonid;
    /**
    * 用户账号
    */
    private String bsUserlogin;
    /**
    * 取消原因
    */
    private String bsCancelreason;
    /**
    * 创建时间
    */
    private Object bsCreatetime;


    public Integer getBsCancelreasonid() {
        return bsCancelreasonid;
    }

    public void setBsCancelreasonid(Integer bsCancelreasonid) {
        this.bsCancelreasonid = bsCancelreasonid;
    }

    public String getBsUserlogin() {
        return bsUserlogin;
    }

    public void setBsUserlogin(String bsUserlogin) {
        this.bsUserlogin = bsUserlogin;
    }

    public String getBsCancelreason() {
        return bsCancelreason;
    }

    public void setBsCancelreason(String bsCancelreason) {
        this.bsCancelreason = bsCancelreason;
    }

    public Object getBsCreatetime() {
        return bsCreatetime;
    }

    public void setBsCreatetime(Object bsCreatetime) {
        this.bsCreatetime = bsCreatetime;
    }

}