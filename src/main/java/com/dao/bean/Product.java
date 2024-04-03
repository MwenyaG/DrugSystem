package com.dao.bean;

import java.util.Date;



public class Product {
    private String prname;
    private int prid;
    private String mfname;
    private String prmanufacturer;
    private String prmfg;
    private Double prprice;
    private String quantity;
    private int oid;
    private Double price;
    private int sid;
    private Date orderdatetime;
    private String exp;
    private int uid;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    private int flag;

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public Date getOrderdatetime() {
        return orderdatetime;
    }

    public void setOrderdatetime(Date orderdatetime) {
        this.orderdatetime = orderdatetime;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrmanufacturer() {
        return prmanufacturer;
    }

    public void setPrmanufacturer(String prmanufacturer) {
        this.prmanufacturer = prmanufacturer;
    }

    public String getPrmfg() {
        return prmfg;
    }

    public void setPrmfg(String prmfg) {
        this.prmfg = prmfg;
    }

    public Double getPrprice() {
        return prprice;
    }

    public void setPrprice(Double prprice) {
        this.prprice = prprice;
    }

    public String getPrname() {
        return prname;
    }

    public void setPrname(String prname) {
        this.prname = prname;
    }

    public int getPrid() {
        return prid;
    }

    public void setPrid(int prid) {
        this.prid = prid;
    }

    public String getMfname() {
        return mfname;
    }

    public void setMfname(String mfname) {
        this.mfname = mfname;
    }
}
