package cn.lht.entity;

import java.io.Serializable;

/**
 * (BsPress)实体类
 *
 * @author makejava
 * @since 2020-02-21 22:46:19
 */
public class BsPress implements Serializable {
    private static final long serialVersionUID = -98003788452145749L;
    /**
    * 出版社Id
    */
    private Integer bsPressid;
    /**
    * 出版社编号
    */
    private String bsPressnum;
    /**
    * 出版社名称
    */
    private String bsPressname;


    public Integer getBsPressid() {
        return bsPressid;
    }

    public void setBsPressid(Integer bsPressid) {
        this.bsPressid = bsPressid;
    }

    public String getBsPressnum() {
        return bsPressnum;
    }

    public void setBsPressnum(String bsPressnum) {
        this.bsPressnum = bsPressnum;
    }

    public String getBsPressname() {
        return bsPressname;
    }

    public void setBsPressname(String bsPressname) {
        this.bsPressname = bsPressname;
    }

    @Override
    public String toString() {
        return "BsPress{" +
                "bsPressid=" + bsPressid +
                ", bsPressnum='" + bsPressnum + '\'' +
                ", bsPressname='" + bsPressname + '\'' +
                '}';
    }
}