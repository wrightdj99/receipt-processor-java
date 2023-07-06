package com.example.receiptprocessingchallengejava.Models;
/*Here we have the class that will be used to define a single item within
* our JSON Receipts. All the items won't just be treated as Strings or simple arrays,
* but rather as actual objects that the development team has the option
* of analyzing more thoroughly (i.e. you could save the receipt objects to a database,
* or maybe send them off to some kind of recommender system for an end-user).*/
public class Item {

    private String shortDescription;
    private String price;

    public Item() {
    }

    //This will prove useful whenever we want to represent something as a string on the console.
    @Override
    public String toString() {
        return "Item{" +
                "shortDesc='" + shortDescription + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
