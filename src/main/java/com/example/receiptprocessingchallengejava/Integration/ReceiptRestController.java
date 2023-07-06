package com.example.receiptprocessingchallengejava.Integration;
//Getting our Receipt data class in
import com.example.receiptprocessingchallengejava.Models.Receipt;
//Helper functions that will prove useful when parsing JSON and determining points.
import com.example.receiptprocessingchallengejava.HelperFunctions.*;
//For this project, I used Google's GSON parser.
import com.google.gson.Gson;
//Some needed Java Spring calls...
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.*;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
@RestController
public class ReceiptRestController {

    /*The GitHub documentation said we were allowed to store information in memory.
    HashMaps seemed the most database-like in-memory structure I could use for this project.
    Also, they have pretty solid Big-O performance for basic get/put/delete operations.*/
    HashMap<String, Receipt> receiptLibrary = new HashMap<>();
    /*This method, processReceipt, takes in a Receipt from the client
    * and returns a UUID made from the passed in Receipt, while storing both in the receiptLibrary
    * HashMap.*/
    @PostMapping(value = "/receipts/processes")
    public Object processReceipt(@RequestBody Receipt receipt){
        Gson gson = new Gson();
        //All this HashMap will ever do is store the single key-value pair of this receipt and its corresponding UUID.
        HashMap<String, String> receiptHm = new HashMap<String, String>();
        String receiptString = gson.toJson(receipt);
        Receipt processedReceipt = gson.fromJson(receiptString, Receipt.class);
        UUID uuid = UUID.nameUUIDFromBytes(processedReceipt.toString().getBytes());
        receiptHm.put("id", uuid.toString());
        receiptLibrary.put(String.valueOf(uuid), processedReceipt);
        return receiptHm;
    }

    /*From the last method, we can now use the ID we got back from processReceipt()
    * to award points to the corresponding Receipt. */
    @GetMapping(value = "/receipts/{id}/points")
    public Object getPoints(@PathVariable("id") String receiptId){
        //The workingReceipt will be retrieved from receiptLibrary.
        Receipt workingReceipt = receiptLibrary.get(receiptId);
        //These will make our code a bit easier to read further down. Less risk of long calls.
        String retailer = workingReceipt.getRetailer();
        Date purchaseDate = workingReceipt.getPurchaseDate();
        String purchaseTime = workingReceipt.getPurchaseTime();
        String total = workingReceipt.getTotal();
        //Points we'll return.
        int points = 0;
        //All that's left is to add up points with help from our HelperFunctions.
        //The ints and booleans will make the method calls, and then we'll add the
        //ints to the points value and use simple if-statements to check if the booleans are true.
        int retailerNameLen = CharAnalyzer.charCounterHelper(retailer);
        boolean totalIsWhole = DollarAnalyzer.dollarIsWhole(Float.parseFloat(total));
        boolean totalIsMultiple = DollarAnalyzer.dollarIsMultipleOf(Float.parseFloat(total), 0.25F);
        boolean dayIsOdd = DateAnalyzer.dayIsOdd(purchaseDate);
        boolean purchaseIsBetween = TimeAnalyzer.timeIsBetween("16:00", "14:00", purchaseTime);
        int itemPointsToAssignPairs = ItemAnalyzer.pointsEarnedByPairs(workingReceipt);
        int itemPointsToAssignDesc = ItemAnalyzer.pointsEarnedByItemTitle(workingReceipt);
        if(totalIsWhole){
            points += 50;
        }
        if(totalIsMultiple){
            points += 25;
        }
        if(dayIsOdd){
            points += 6;
        }
        if(purchaseIsBetween){
            points += 10;
        }
        points += retailerNameLen;
        points += itemPointsToAssignPairs;
        points += itemPointsToAssignDesc;
        //One last little HashMap that will store a single key-value pair for our points to return.
        HashMap<String, String> pointAmount = new HashMap<>();
        pointAmount.put("points", String.valueOf(points));
        return pointAmount;
    }

}
