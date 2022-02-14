package com.swathi.swathitest;

public class MyCarModel {

    public String getTitle() {
        return title;
    }

    public MyCarModel(String title, String regno, String price, String reg_date, int myImage) {
        this.title = title;
        this.reg_date = reg_date;
        this.price = price;
        this.regno = regno;
        this.myImage = myImage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    String title, regno, price, reg_date;
    int myImage = 0;

    public int getMyImage() {
        return myImage;
    }

    public void setMyImage(int myImage) {
        this.myImage = myImage;
    }
}
