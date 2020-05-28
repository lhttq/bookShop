package cn.lht.entity;

import java.io.Serializable;

/**
 * (BsRejectreason)实体类
 *
 * @author makejava
 * @since 2020-02-24 16:10:57
 */
public class BsRejectreason implements Serializable {
    private static final long serialVersionUID = 989124897995389660L;
    /**
    * 拒收原因Id
    */
    private Integer bsRejectreasonid;
    /**
    * 账号
    */
    private String bsLoginname;
    /**
    * 拒收原因
    */
    private String bsRejectreason;
    /**
    * 创建时间
    */
    private Object bsCreatetime;


    public Integer getBsRejectreasonid() {
        return bsRejectreasonid;
    }

    public void setBsRejectreasonid(Integer bsRejectreasonid) {
        this.bsRejectreasonid = bsRejectreasonid;
    }

    public String getBsLoginname() {
        return bsLoginname;
    }

    public void setBsLoginname(String bsLoginname) {
        this.bsLoginname = bsLoginname;
    }

    public String getBsRejectreason() {
        return bsRejectreason;
    }

    public void setBsRejectreason(String bsRejectreason) {
        this.bsRejectreason = bsRejectreason;
    }

    public Object getBsCreatetime() {
        return bsCreatetime;
    }

    public void setBsCreatetime(Object bsCreatetime) {
        this.bsCreatetime = bsCreatetime;
    }

}