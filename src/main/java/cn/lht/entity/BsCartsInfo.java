package cn.lht.entity;

import java.io.Serializable;

public class BsCartsInfo implements Serializable {
    private static final long serialVersionUID = 5978175337175121832L;
    /**
     * 用户Id
     */
    private Integer userId;
    /**
     * 图书信息
     */
    private BsBooks bsBooks;
    /**
     * 分类信息
     */
    private BsBookclass bsBookclass;
    /**
     * 出版社信息
     */
    private BsPress bsPress;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BsBooks getBsBooks() {
        return bsBooks;
    }

    public void setBsBooks(BsBooks bsBooks) {
        this.bsBooks = bsBooks;
    }

    public BsBookclass getBsBookclass() {
        return bsBookclass;
    }

    public void setBsBookclass(BsBookclass bsBookclass) {
        this.bsBookclass = bsBookclass;
    }

    public BsPress getBsPress() {
        return bsPress;
    }

    public void setBsPress(BsPress bsPress) {
        this.bsPress = bsPress;
    }
}
