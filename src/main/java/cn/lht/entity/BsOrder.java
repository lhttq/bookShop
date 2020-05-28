package cn.lht.entity;

import java.io.Serializable;

/**
 * (BsOrder)实体类
 *
 * @author makejava
 * @since 2020-04-13 15:55:14
 */
public class BsOrder implements Serializable {
    private static final long serialVersionUID = -38551781657616012L;
    /**
    * 自增Id
    */
    private Integer bsOrderid;
    /**
    * 订单号
    */
    private String bsOrderno;
    /**
    * 用户Id
    */
    private Integer bsUserid;
    /**
    * 订单状态：-3用户拒收；-2未付款订单；-1用户取消；0代发货；1配送中；2用户确认收货
    */
    private Integer bsOrderstatus;
    /**
    * 商品总价格-未进行任何折扣的总价格
    */
    private Integer bsBooksmoney;
    /**
    * 收货方式：0送货上门，1：自提
    */
    private Integer bsLivertype;
    /**
    * 运费
    */
    private Double bsDelivermoney;
    /**
    * 支付方式；0货到付款；1,：在线支付
    */
    private Integer bsPaytype;
    /**
    * 支付来源；1，支付宝，2微信支付
    */
    private Integer bsPayfrom;
    /**
    * 是否支付 0：未支付；1：已支付
    */
    private Integer bsIspay;
    /**
    * 收货人名称
    */
    private String bsUsername;
    /**
    * 收货人地址
    */
    private String bsUseraddress;
    /**
    * 收货人手机
    */
    private String bsUserphone;
    /**
    * 是否需要发票 1需要，0不需要
    */
    private Integer bsIsinvoice;
    /**
    * 发票抬头 
    */
    private String bsInvoiceclient;
    /**
    * 订单备注
    */
    private String bsOrderremarks;
    
    private Integer bsNeedpay;
    /**
    * 是否退款，0否，1是
    */
    private Integer bsIsrefund;
    /**
    * 取消原因Id
    */
    private Integer bsCancelreasonid;
    /**
    * 拒收原因Id
    */
    private Integer bsRejectreasonid;
    /**
    * 是否订单已完结0：未完结。1：已完结
    */
    private Integer bsIsclosed;
    /**
    * 订单流水号
    */
    private String bsOrderrunique;
    /**
    * 收货时间
    */
    private String bsReceivetime;
    /**
    * 发货时间
    */
    private String bsDeliverytime;
    /**
    * 快递公司Id
    */
    private Integer bsExpressid;
    /**
    * 快递号
    */
    private String bsPressno;
    /**
    * 订单有效标志1，有效，0 无效
    */
    private Integer bsDataflag;
    /**
    * 创建时间
    */
    private String bsCreatetime;
    /**
    * 最后一级Id
    */
    private Integer bsAreaid;
    /**
    * 区域Id路径
    */
    private String bsAreaidpath;


    public Integer getBsOrderid() {
        return bsOrderid;
    }

    public void setBsOrderid(Integer bsOrderid) {
        this.bsOrderid = bsOrderid;
    }

    public String getBsOrderno() {
        return bsOrderno;
    }

    public void setBsOrderno(String bsOrderno) {
        this.bsOrderno = bsOrderno;
    }

    public Integer getBsUserid() {
        return bsUserid;
    }

    public void setBsUserid(Integer bsUserid) {
        this.bsUserid = bsUserid;
    }

    public Integer getBsOrderstatus() {
        return bsOrderstatus;
    }

    public void setBsOrderstatus(Integer bsOrderstatus) {
        this.bsOrderstatus = bsOrderstatus;
    }

    public Integer getBsBooksmoney() {
        return bsBooksmoney;
    }

    public void setBsBooksmoney(Integer bsBooksmoney) {
        this.bsBooksmoney = bsBooksmoney;
    }

    public Integer getBsLivertype() {
        return bsLivertype;
    }

    public void setBsLivertype(Integer bsLivertype) {
        this.bsLivertype = bsLivertype;
    }

    public Double getBsDelivermoney() {
        return bsDelivermoney;
    }

    public void setBsDelivermoney(Double bsDelivermoney) {
        this.bsDelivermoney = bsDelivermoney;
    }

    public Integer getBsPaytype() {
        return bsPaytype;
    }

    public void setBsPaytype(Integer bsPaytype) {
        this.bsPaytype = bsPaytype;
    }

    public Integer getBsPayfrom() {
        return bsPayfrom;
    }

    public void setBsPayfrom(Integer bsPayfrom) {
        this.bsPayfrom = bsPayfrom;
    }

    public Integer getBsIspay() {
        return bsIspay;
    }

    public void setBsIspay(Integer bsIspay) {
        this.bsIspay = bsIspay;
    }

    public String getBsUsername() {
        return bsUsername;
    }

    public void setBsUsername(String bsUsername) {
        this.bsUsername = bsUsername;
    }

    public String getBsUseraddress() {
        return bsUseraddress;
    }

    public void setBsUseraddress(String bsUseraddress) {
        this.bsUseraddress = bsUseraddress;
    }

    public String getBsUserphone() {
        return bsUserphone;
    }

    public void setBsUserphone(String bsUserphone) {
        this.bsUserphone = bsUserphone;
    }

    public Integer getBsIsinvoice() {
        return bsIsinvoice;
    }

    public void setBsIsinvoice(Integer bsIsinvoice) {
        this.bsIsinvoice = bsIsinvoice;
    }

    public String getBsInvoiceclient() {
        return bsInvoiceclient;
    }

    public void setBsInvoiceclient(String bsInvoiceclient) {
        this.bsInvoiceclient = bsInvoiceclient;
    }

    public String getBsOrderremarks() {
        return bsOrderremarks;
    }

    public void setBsOrderremarks(String bsOrderremarks) {
        this.bsOrderremarks = bsOrderremarks;
    }

    public Integer getBsNeedpay() {
        return bsNeedpay;
    }

    public void setBsNeedpay(Integer bsNeedpay) {
        this.bsNeedpay = bsNeedpay;
    }

    public Integer getBsIsrefund() {
        return bsIsrefund;
    }

    public void setBsIsrefund(Integer bsIsrefund) {
        this.bsIsrefund = bsIsrefund;
    }

    public Integer getBsCancelreasonid() {
        return bsCancelreasonid;
    }

    public void setBsCancelreasonid(Integer bsCancelreasonid) {
        this.bsCancelreasonid = bsCancelreasonid;
    }

    public Integer getBsRejectreasonid() {
        return bsRejectreasonid;
    }

    public void setBsRejectreasonid(Integer bsRejectreasonid) {
        this.bsRejectreasonid = bsRejectreasonid;
    }

    public Integer getBsIsclosed() {
        return bsIsclosed;
    }

    public void setBsIsclosed(Integer bsIsclosed) {
        this.bsIsclosed = bsIsclosed;
    }

    public String getBsOrderrunique() {
        return bsOrderrunique;
    }

    public void setBsOrderrunique(String bsOrderrunique) {
        this.bsOrderrunique = bsOrderrunique;
    }

    public String getBsReceivetime() {
        return bsReceivetime;
    }

    public void setBsReceivetime(String bsReceivetime) {
        this.bsReceivetime = bsReceivetime;
    }

    public String getBsDeliverytime() {
        return bsDeliverytime;
    }

    public void setBsDeliverytime(String bsDeliverytime) {
        this.bsDeliverytime = bsDeliverytime;
    }

    public Integer getBsExpressid() {
        return bsExpressid;
    }

    public void setBsExpressid(Integer bsExpressid) {
        this.bsExpressid = bsExpressid;
    }

    public String getBsPressno() {
        return bsPressno;
    }

    public void setBsPressno(String bsPressno) {
        this.bsPressno = bsPressno;
    }

    public Integer getBsDataflag() {
        return bsDataflag;
    }

    public void setBsDataflag(Integer bsDataflag) {
        this.bsDataflag = bsDataflag;
    }

    public String getBsCreatetime() {
        return bsCreatetime;
    }

    public void setBsCreatetime(String bsCreatetime) {
        this.bsCreatetime = bsCreatetime;
    }

    public Integer getBsAreaid() {
        return bsAreaid;
    }

    public void setBsAreaid(Integer bsAreaid) {
        this.bsAreaid = bsAreaid;
    }

    public String getBsAreaidpath() {
        return bsAreaidpath;
    }

    public void setBsAreaidpath(String bsAreaidpath) {
        this.bsAreaidpath = bsAreaidpath;
    }

    @Override
    public String toString() {
        return "BsOrder{" +
                "bsOrderid=" + bsOrderid +
                ", bsOrderno='" + bsOrderno + '\'' +
                ", bsUserid=" + bsUserid +
                ", bsOrderstatus=" + bsOrderstatus +
                ", bsBooksmoney=" + bsBooksmoney +
                ", bsLivertype=" + bsLivertype +
                ", bsDelivermoney=" + bsDelivermoney +
                ", bsPaytype=" + bsPaytype +
                ", bsPayfrom=" + bsPayfrom +
                ", bsIspay=" + bsIspay +
                ", bsUsername='" + bsUsername + '\'' +
                ", bsUseraddress='" + bsUseraddress + '\'' +
                ", bsUserphone='" + bsUserphone + '\'' +
                ", bsIsinvoice=" + bsIsinvoice +
                ", bsInvoiceclient='" + bsInvoiceclient + '\'' +
                ", bsOrderremarks='" + bsOrderremarks + '\'' +
                ", bsNeedpay=" + bsNeedpay +
                ", bsIsrefund=" + bsIsrefund +
                ", bsCancelreasonid=" + bsCancelreasonid +
                ", bsRejectreasonid=" + bsRejectreasonid +
                ", bsIsclosed=" + bsIsclosed +
                ", bsOrderrunique='" + bsOrderrunique + '\'' +
                ", bsReceivetime='" + bsReceivetime + '\'' +
                ", bsDeliverytime='" + bsDeliverytime + '\'' +
                ", bsExpressid=" + bsExpressid +
                ", bsPressno='" + bsPressno + '\'' +
                ", bsDataflag=" + bsDataflag +
                ", bsCreatetime='" + bsCreatetime + '\'' +
                ", bsAreaid=" + bsAreaid +
                ", bsAreaidpath='" + bsAreaidpath + '\'' +
                '}';
    }
}