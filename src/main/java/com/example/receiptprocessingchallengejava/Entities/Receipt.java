package com.example.receiptprocessingchallengejava.Entities;
import java.util.*;
public class Receipt {
   private String retailer;
   private Date purchaseDate;
   private String purchaseTime;
   private Item[] items;
   private String total;

   public Receipt(){
       this.retailer = retailer;
       this.purchaseDate = purchaseDate;
       this.purchaseTime = purchaseTime;
       this.items = items;
       this.total = total;
   }

    public String getRetailer() {
        return retailer;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public Item[] getItems() {
        return items;
    }

    public String getTotal() {
        return total;
    }

    public void setRetailer(String retailer) {
        this.retailer = retailer;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
