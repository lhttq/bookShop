package cn.lht.entity;

import java.io.Serializable;

/**
 * (BsCarts)实体类
 *
 * @author makejava
 * @since 2020-03-03 20:53:54
 */
public class BsCarts implements Serializable {
    private static final long serialVersionUID = -59571604901121107L;
    /**
    * 自增ID
    */
    private Integer bsCartid;
    /**
    * 用户ID
    */
    private Integer bsUserid;
    /**
    * 是否选中{1选中，0未选中}
    */
    private Integer bsIscheck;
    /**
    * 商品id
    */
    private Integer bsGoodsid;
    /**
    * 商品规格ID
    */
    private String bsGoodsspecld;
    /**
    * 商品数量
    */
    private Integer bsCartnum;


    public Integer getBsCartid() {
        return bsCartid;
    }

    public void setBsCartid(Integer bsCartid) {
        this.bsCartid = bsCartid;
    }

    public Integer getBsUserid() {
        return bsUserid;
    }

    public void setBsUserid(Integer bsUserid) {
        this.bsUserid = bsUserid;
    }

    public Integer getBsIscheck() {
        return bsIscheck;
    }

    public void setBsIscheck(Integer bsIscheck) {
        this.bsIscheck = bsIscheck;
    }

    public Integer getBsGoodsid() {
        return bsGoodsid;
    }

    public void setBsGoodsid(Integer bsGoodsid) {
        this.bsGoodsid = bsGoodsid;
    }

    public String getBsGoodsspecld() {
        return bsGoodsspecld;
    }

    public void setBsGoodsspecld(String bsGoodsspecld) {
        this.bsGoodsspecld = bsGoodsspecld;
    }

    public Integer getBsCartnum() {
        return bsCartnum;
    }

    public void setBsCartnum(Integer bsCartnum) {
        this.bsCartnum = bsCartnum;
    }

    @Override
    public String toString() {
        return "BsCarts{" +
                "bsCartid=" + bsCartid +
                ", bsUserid=" + bsUserid +
                ", bsIscheck=" + bsIscheck +
                ", bsGoodsid=" + bsGoodsid +
                ", bsGoodsspecld='" + bsGoodsspecld + '\'' +
                ", bsCartnum=" + bsCartnum +
                '}';
    }
}