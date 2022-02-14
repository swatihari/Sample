package com.swathi.swathitest;

public class HomeScreen {

    public String getTitle() {
        return title;
    }

    public int getImg() {
        return imgItem;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImgItem() {
        return imgItem;
    }

    public void setImgItem(int imgItem) {
        this.imgItem = imgItem;
    }

    String title ="";
    int imgItem=0;

    public HomeScreen(String title, int imgItem) {
        this.title = title;
        this.imgItem = imgItem;
    }
}

