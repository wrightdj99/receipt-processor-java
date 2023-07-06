package com.example.receiptprocessingchallengejava.HelperFunctions;
import com.example.receiptprocessingchallengejava.Models.Item;
import com.example.receiptprocessingchallengejava.Models.Receipt;
/*Some of the longer helper methods in this program are here, but they're not too complex.
* All we are really doing here is just checking for various things in our nested JSON Items array
* that comes to this program via a request.*/
public class ItemAnalyzer {

    //Checking how many items are in an items list and awarding 5 points for every 2 items.
    public static int pointsEarnedByPairs(Receipt receipt){
        int pointsToReturn = 0;
        Item[] receiptItems = receipt.getItems();
        int totalItems = receiptItems.length;
        pointsToReturn += Math.floor((double) totalItems /2);
        pointsToReturn *= pointsToReturn * 5;
        return pointsToReturn;
    }
    //We do some simple math here with the price of an item if the shortDescription of an item
    //is a multiple of 3.
    public static int pointsEarnedByItemTitle(Receipt receipt){
        int pointsToReturn = 0;
        Item[] receiptItems = receipt.getItems();
        for(Item i : receiptItems){
            double itemPrice = Double.parseDouble(i.getPrice());
            if(i.getShortDescription().length() % 3 == 0){
                itemPrice = Math.ceil(itemPrice * 0.2);
                pointsToReturn += itemPrice;
            }
        }
        return pointsToReturn;
    }
}
