package com.example.receiptprocessingchallengejava.Models;
import java.util.*;
/*This is the data class that will represent all of our receipts. Every receipt will have
a retailer, a purchaseDate, a purchaseTime, a total amount, and a JSON array of items bought.
The best thing about both our Receipt and Item classes is that we can just get a ready-to-go instance
 of either class and then just use the below getters and setters to initialize the incoming JSON (more about
 this in the ReceiptRestController)*/
public class Receipt {
   private String retailer;
   private Date purchaseDate;
   private String purchaseTime;
   private String total;
   private Item[] items;

   public Receipt(){
   }
    //Convenient toString method if you ever want a console representation of data.
    @Override
    public String toString() {
        return "Receipt{" +
                "retailer='" + retailer + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", purchaseTime='" + purchaseTime + '\'' +
                ", total='" + total + '\'' +
                ", items=" + Arrays.toString(items) +
                '}';
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
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


    public void setTotal(String total) {
        this.total = total;
    }

}


