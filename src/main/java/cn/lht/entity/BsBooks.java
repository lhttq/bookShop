package cn.lht.entity;

import java.io.Serializable;

/**
 * (BsBooks)实体类
 *
 * @author makejava
 * @since 2020-02-26 19:24:16
 */
public class BsBooks implements Serializable {
    private static final long serialVersionUID = 688230432152833168L;
    /**
    * 自增ID
    */
    private Integer bsBookid;
    /**
    * 图书编号
    */
    private String bsBooksn;
    /**
    * 图书名称
    */
    private String bsBookname;
    /**
    * 图书作者
    */
    private String bsBookauthor;
    /**
    * 图书类别Id
    */
    private Object bsBookclassid;
    /**
    * 图书出版日期
    */
    private Object bsBookbt;
    /**
    * 出版社编号
    */
    private String bsPressnum;
    /**
    * 图书价格
    */
    private Double bsBookprice;
    /**
    * 图书封面
    */
    private String bsBookcover;
    /**
     * 图书省份
     */
    private String bsProvince;
    /**
     * 图书数量
     */
    private Integer bsBooksnum;


    public Integer getBsBookid() {
        return bsBookid;
    }

    public void setBsBookid(Integer bsBookid) {
        this.bsBookid = bsBookid;
    }

    public String getBsBooksn() {
        return bsBooksn;
    }

    public void setBsBooksn(String bsBooksn) {
        this.bsBooksn = bsBooksn;
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

    public Object getBsBookclassid() {
        return bsBookclassid;
    }

    public void setBsBookclassid(Object bsBookclassid) {
        this.bsBookclassid = bsBookclassid;
    }

    public Object getBsBookbt() {
        return bsBookbt;
    }

    public void setBsBookbt(Object bsBookbt) {
        this.bsBookbt = bsBookbt;
    }

    public String getBsPressnum() {
        return bsPressnum;
    }

    public void setBsPressnum(String bsPressnum) {
        this.bsPressnum = bsPressnum;
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

    public String getBsProvince() {
        return bsProvince;
    }

    public void setBsProvince(String bsProvince) {
        this.bsProvince = bsProvince;
    }

    public Integer getBsBooksnum() {
        return bsBooksnum;
    }

    public void setBsBooksnum(Integer bsBooksnum) {
        this.bsBooksnum = bsBooksnum;
    }

    @Override
    public String toString() {
        return "BsBooks{" +
                "bsBookid=" + bsBookid +
                ", bsBooksn='" + bsBooksn + '\'' +
                ", bsBookname='" + bsBookname + '\'' +
                ", bsBookauthor='" + bsBookauthor + '\'' +
                ", bsBookclassid=" + bsBookclassid +
                ", bsBookbt=" + bsBookbt +
                ", bsPressnum='" + bsPressnum + '\'' +
                ", bsBookprice=" + bsBookprice +
                ", bsBookcover='" + bsBookcover + '\'' +
                ", bsProvince='" + bsProvince + '\'' +
                ", bsBooksnum=" + bsBooksnum +
                '}';
    }
}