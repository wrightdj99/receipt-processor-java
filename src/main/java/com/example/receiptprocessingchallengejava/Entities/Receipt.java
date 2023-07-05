package com.example.receiptprocessingchallengejava.Entities;
import java.util.*;
public class Receipt {
   private String retailer;
   private Date purchaseDate;
   private String purchaseTime;
   private String total;

   public Receipt(){
   }

    @Override
    public String toString() {
        return "Receipt{" +
                "retailer='" + retailer + '\'' +
                ", purchaseDate=" + purchaseDate +
                ", purchaseTime='" + purchaseTime + '\'' +
                ", total='" + total + '\'' +
                '}';
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
    /*class Item{
        public Item() {
        }

        public String getShortDesc() {
            return shortDesc;
        }

        public void setShortDesc(String shortDesc) {
            this.shortDesc = shortDesc;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        private String shortDesc;
        private String price;}*/

}

