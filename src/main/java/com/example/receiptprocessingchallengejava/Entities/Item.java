package com.example.receiptprocessingchallengejava.Entities;

public class Item {
    private String shortDesc;
    private String price;
    public Item(String shortDesc, String price){
        this.shortDesc = shortDesc;
        this.price = price;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }
}
