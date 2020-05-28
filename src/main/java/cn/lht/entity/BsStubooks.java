package cn.lht.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (BsStubooks)实体类
 *
 * @author makejava
 * @since 2020-04-05 18:21:25
 */
public class BsStubooks implements Serializable {
    private static final long serialVersionUID = -95461729939740207L;
    /**
    * 自增ID
    */
    private Integer bsBookid;
    /**
    * 账号
    */
    private String bsLoginname;
    /**
    * 图书名称
    */
    private String bsBookname;
    /**
    * 图书作者
    */
    private String bsBookauthor;
    /**
    * 出版社名称
    */
    private String bsPressname;
    /**
    * 图书价格
    */
    private Double bsBookprice;
    /**
    * 图书封面
    */
    private String bsBookcover;
    /**
    * 书籍数量
    */
    private Integer bsBooknum;
    /**
    * 所在学校
    */
    private String bsUniversity;
    /**
    * 购买者账号，通过此字段获取购买者联系方式
    */
    private String bsBuylogin;
    /**
    * 创建时间
    */
    private Date bsCratetime;


    public Integer getBsBookid() {
        return bsBookid;
    }

    public void setBsBookid(Integer bsBookid) {
        this.bsBookid = bsBookid;
    }

    public String getBsLoginname() {
        return bsLoginname;
    }

    public void setBsLoginname(String bsLoginname) {
        this.bsLoginname = bsLoginname;
    }

    public String getBsBookname() {
        return bsBookname;
    }

    public void setBsBookname(String bsBookname) {
        this.bsBookname = bsBookname;
    }

    public String getBsBookauthor() {
        return bsBookauthor;
    }

    public void setBsBookauthor(String bsBookauthor) {
        this.bsBookauthor = bsBookauthor;
    }

    public String getBsPressname() {
        return bsPressname;
    }

    public void setBsPressname(String bsPressname) {
        this.bsPressname = bsPressname;
    }

    public Double getBsBookprice() {
        return bsBookprice;
    }

    public void setBsBookprice(Double bsBookprice) {
        this.bsBookprice = bsBookprice;
    }

    public String getBsBookcover() {
        return bsBookcover;
    }

    public void setBsBookcover(String bsBookcover) {
        this.bsBookcover = bsBookcover;
    }

    public Integer getBsBooknum() {
        return bsBooknum;
    }

    public void setBsBooknum(Integer bsBooknum) {
        this.bsBooknum = bsBooknum;
    }

    public String getBsUniversity() {
        return bsUniversity;
    }

    public void setBsUniversity(String bsUniversity) {
        this.bsUniversity = bsUniversity;
    }

    public String getBsBuylogin() {
        return bsBuylogin;
    }

    public void setBsBuylogin(String bsBuylogin) {
        this.bsBuylogin = bsBuylogin;
    }

    public Date getBsCratetime() {
        return bsCratetime;
    }

    public void setBsCratetime(Date bsCratetime) {
        this.bsCratetime = bsCratetime;
    }

    @Override
    public String toString() {
        return "BsStubooks{" +
                "bsBookid=" + bsBookid +
                ", bsLoginname='" + bsLoginname + '\'' +
                ", bsBookname='" + bsBookname + '\'' +
                ", bsBookauthor='" + bsBookauthor + '\'' +
                ", bsPressname='" + bsPressname + '\'' +
                ", bsBookprice=" + bsBookprice +
                ", bsBookcover='" + bsBookcover + '\'' +
                ", bsBooknum=" + bsBooknum +
                ", bsUniversity='" + bsUniversity + '\'' +
                ", bsBuylogin='" + bsBuylogin + '\'' +
                ", bsCratetime=" + bsCratetime +
                '}';
    }
}