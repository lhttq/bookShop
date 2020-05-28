package cn.lht.entity;

import java.io.Serializable;

/**
 * (BsOrderbooks)实体类
 *
 * @author makejava
 * @since 2020-04-13 16:02:43
 */
public class BsOrderbooks implements Serializable {
    private static final long serialVersionUID = -64401151835493875L;
    /**
    * 自增id
    */
    private Integer bsOrderbooksid;
    /**
    * 订单ID
    */
    private Integer bsOrderid;
    /**
    * 图书ID
    */
    private Integer bsGoodsid;
    /**
    * 图书数量
    */
    private Integer bsGoodsnum;
    /**
    * 图书价格
    */
    private Double bsGoodsprice;
    /**
    * 图书名称
    */
    private String bsGoodsname;
    /**
    * 图书封面
    */
    private String bsGoodimg;


    public Integer getBsOrderbooksid() {
        return bsOrderbooksid;
    }

    public void setBsOrderbooksid(Integer bsOrderbooksid) {
        this.bsOrderbooksid = bsOrderbooksid;
    }

    public Integer getBsOrderid() {
        return bsOrderid;
    }

    public void setBsOrderid(Integer bsOrderid) {
        this.bsOrderid = bsOrderid;
    }

    public Integer getBsGoodsid() {
        return bsGoodsid;
    }

    public void setBsGoodsid(Integer bsGoodsid) {
        this.bsGoodsid = bsGoodsid;
    }

    public Integer getBsGoodsnum() {
        return bsGoodsnum;
    }

    public void setBsGoodsnum(Integer bsGoodsnum) {
        this.bsGoodsnum = bsGoodsnum;
    }

    public Double getBsGoodsprice() {
        return bsGoodsprice;
    }

    public void setBsGoodsprice(Double bsGoodsprice) {
        this.bsGoodsprice = bsGoodsprice;
    }

    public String getBsGoodsname() {
        return bsGoodsname;
    }

    public void setBsGoodsname(String bsGoodsname) {
        this.bsGoodsname = bsGoodsname;
    }

    public String getBsGoodimg() {
        return bsGoodimg;
    }

    public void setBsGoodimg(String bsGoodimg) {
        this.bsGoodimg = bsGoodimg;
    }

}