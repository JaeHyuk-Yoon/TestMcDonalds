/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Date;

/**
 *
 * @author heejin
 */
public class Orderlist {
    private int ordernum;
    private Date date;
    private String menu;
    private String branch;
    private int price;
    private String complete;

    public Orderlist() {
    }

    public Orderlist(int ordernum, Date date, String menu, String branch, int price, String complete) {
        this.ordernum = ordernum;
        this.date = date;
        this.menu = menu;
        this.branch = branch;
        this.price = price;
        this.complete = complete;
    }

    public int getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(int ordernum) {
        this.ordernum = ordernum;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
