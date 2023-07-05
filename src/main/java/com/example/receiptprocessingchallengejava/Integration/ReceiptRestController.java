package com.example.receiptprocessingchallengejava.Integration;
import com.example.receiptprocessingchallengejava.Entities.Receipt;
import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.*;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration.class})
@RestController
public class ReceiptRestController {
    HashMap<String, Receipt> receiptLibrary = new HashMap<>();
    @GetMapping(value = "/testing")
    public Object testCall() {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Message", "Hello there!");
        return hm;
    }

    @PostMapping(value = "/receipts/processes")
    public Object createUUID(@RequestBody Receipt receipt){
        Gson gson = new Gson();
        HashMap<String, String> receiptHm = new HashMap<String, String>();
        String receiptString = gson.toJson(receipt);
        Receipt processedReceipt = gson.fromJson(receiptString, Receipt.class);
//        System.out.println("GOT RETAILER: " + processedReceipt.getRetailer());
//        System.out.println("GOT PURCHASE DATE: " + processedReceipt.getPurchaseDate());
//        System.out.println("GOT PURCHASE TIME: " + processedReceipt.getPurchaseTime());
//        System.out.println("GOT TOTAL: " + processedReceipt.getTotal());
        UUID uuid = UUID.nameUUIDFromBytes(processedReceipt.toString().getBytes());
        receiptHm.put("id", uuid.toString());
        receiptLibrary.put(String.valueOf(uuid), processedReceipt);
        receiptLibrary.forEach((key, value) -> {
            System.out.println("ID: " + key + "Receipt: " + value.toString());
        });
        return receiptHm;
    }
}
