package cn.lht.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (BsUsers)实体类
 *
 * @author makejava
 * @since 2020-04-06 23:52:45
 */
public class BsUsers implements Serializable {
    private static final long serialVersionUID = 595327053109798630L;
    /**
    * 自增id
    */
    private Integer bsUserid;
    /**
    * 账号
    */
    private String bsLoginname;
    /**
    * 安全码
    */
    private Integer bsLoginsecret;
    /**
    * 用户类型：学校用户1，普通用户0
    */
    private Integer bsUsertype;
    /**
    * 用户性别：男1，女0
    */
    private Integer bsUsersex;
    /**
    * 用户名
    */
    private String bsUsername;
    /**
    * 真实姓名
    */
    private String bsTruename;
    /**
    * 生日
    */
    private Date bsUserbrithday;
    /**
    * 会员头像
    */
    private String bsUserphoto;
    /**
    * 用户QQ
    */
    private String bsUserqq;
    /**
    * 用户手机
    */
    private String bsUserphone;
    /**
    * 用户邮箱
    */
    private String bsUseremail;
    /**
    * 省份
    */
    private String bsProvince;
    /**
    * 用户所在学校
    */
    private String bsUniversity;


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

    public Integer getBsLoginsecret() {
        return bsLoginsecret;
    }

    public void setBsLoginsecret(Integer bsLoginsecret) {
        this.bsLoginsecret = bsLoginsecret;
    }

    public Integer getBsUsertype() {
        return bsUsertype;
    }

    public void setBsUsertype(Integer bsUsertype) {
        this.bsUsertype = bsUsertype;
    }

    public Integer getBsUsersex() {
        return bsUsersex;
    }

    public void setBsUsersex(Integer bsUsersex) {
        this.bsUsersex = bsUsersex;
    }

    public String getBsUsername() {
        return bsUsername;
    }

    public void setBsUsername(String bsUsername) {
        this.bsUsername = bsUsername;
    }

    public String getBsTruename() {
        return bsTruename;
    }

    public void setBsTruename(String bsTruename) {
        this.bsTruename = bsTruename;
    }

    public Date getBsUserbrithday() {
        return bsUserbrithday;
    }

    public void setBsUserbrithday(Date bsUserbrithday) {
        this.bsUserbrithday = bsUserbrithday;
    }

    public String getBsUserphoto() {
        return bsUserphoto;
    }

    public void setBsUserphoto(String bsUserphoto) {
        this.bsUserphoto = bsUserphoto;
    }

    public String getBsUserqq() {
        return bsUserqq;
    }

    public void setBsUserqq(String bsUserqq) {
        this.bsUserqq = bsUserqq;
    }

    public String getBsUserphone() {
        return bsUserphone;
    }

    public void setBsUserphone(String bsUserphone) {
        this.bsUserphone = bsUserphone;
    }

    public String getBsUseremail() {
        return bsUseremail;
    }

    public void setBsUseremail(String bsUseremail) {
        this.bsUseremail = bsUseremail;
    }

    public String getBsProvince() {
        return bsProvince;
    }

    public void setBsProvince(String bsProvince) {
        this.bsProvince = bsProvince;
    }

    public String getBsUniversity() {
        return bsUniversity;
    }

    public void setBsUniversity(String bsUniversity) {
        this.bsUniversity = bsUniversity;
    }

    @Override
    public String toString() {
        return "BsUsers{" +
                "bsUserid=" + bsUserid +
                ", bsLoginname='" + bsLoginname + '\'' +
                ", bsLoginsecret=" + bsLoginsecret +
                ", bsUsertype=" + bsUsertype +
                ", bsUsersex=" + bsUsersex +
                ", bsUsername='" + bsUsername + '\'' +
                ", bsTruename='" + bsTruename + '\'' +
                ", bsUserbrithday=" + bsUserbrithday +
                ", bsUserphoto='" + bsUserphoto + '\'' +
                ", bsUserqq='" + bsUserqq + '\'' +
                ", bsUserphone='" + bsUserphone + '\'' +
                ", bsUseremail='" + bsUseremail + '\'' +
                ", bsProvince='" + bsProvince + '\'' +
                ", bsUniversity='" + bsUniversity + '\'' +
                '}';
    }
}