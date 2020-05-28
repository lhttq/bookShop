package cn.lht.entity;

import java.io.Serializable;

/**
 * (BsBookclass)实体类
 *
 * @author makejava
 * @since 2020-02-24 16:09:51
 */
public class BsBookclass implements Serializable {
    private static final long serialVersionUID = 192738356063620170L;
    /**
    * 图书类别Id
    */
    private Object bsBookclassid;
    /**
    * 图书类别名称
    */
    private String bsBookclassname;


    public Object getBsBookclassid() {
        return bsBookclassid;
    }

    public void setBsBookclassid(Object bsBookclassid) {
        this.bsBookclassid = bsBookclassid;
    }

    public String getBsBookclassname() {
        return bsBookclassname;
    }

    public void setBsBookclassname(String bsBookclassname) {
        this.bsBookclassname = bsBookclassname;
    }

}