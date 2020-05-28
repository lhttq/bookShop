package cn.lht.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BsAddress)实体类
 *
 * @author makejava
 * @since 2020-03-28 21:34:48
 */
public class BsAddress implements Serializable {
    private static final long serialVersionUID = 479799369119267008L;
    /**
    * 自增ID
    */
    private Integer bsAddressid;
    /**
    * 用户ID
    */
    private Integer bsUserid;
    /**
    * 收货人名称
    */
    private String bsUsername;
    /**
    * 收货人手机
    */
    private String bsUserphone;
    /**
    * 收货地址
    */
    private String bsAreaidpath;
    /**
    * 是否是默认地址
    */
    private Integer bsIsdefault;
    /**
    * 创建时间
    */
    private Date bsCreatetime;


    public Integer getBsAddressid() {
        return bsAddressid;
    }

    public void setBsAddressid(Integer bsAddressid) {
        this.bsAddressid = bsAddressid;
    }

    public Integer getBsUserid() {
        return bsUserid;
    }

    public void setBsUserid(Integer bsUserid) {
        this.bsUserid = bsUserid;
    }

    public String getBsUsername() {
        return bsUsername;
    }

    public void setBsUsername(String bsUsername) {
        this.bsUsername = bsUsername;
    }

    public String getBsUserphone() {
        return bsUserphone;
    }

    public void setBsUserphone(String bsUserphone) {
        this.bsUserphone = bsUserphone;
    }

    public String getBsAreaidpath() {
        return bsAreaidpath;
    }

    public void setBsAreaidpath(String bsAreaidpath) {
        this.bsAreaidpath = bsAreaidpath;
    }

    public Integer getBsIsdefault() {
        return bsIsdefault;
    }

    public void setBsIsdefault(Integer bsIsdefault) {
        this.bsIsdefault = bsIsdefault;
    }

    public Date getBsCreatetime() {
        return bsCreatetime;
    }

    public void setBsCreatetime(Date bsCreatetime) {
        this.bsCreatetime = bsCreatetime;
    }

}