package com.example.receiptprocessingchallengejava.Integration;
import com.example.receiptprocessingchallengejava.Entities.Receipt;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.*;

import static com.example.receiptprocessingchallengejava.Entities.Receipt.receiptList;

@RestController
public class ReceiptRestController {
    HashMap<String, JsonObject> receiptLibrary = new HashMap<String, JsonObject>();
    @GetMapping(value = "/testing")
    public Object testCall() {
        HashMap<String, String> hm = new HashMap<String, String>();
        hm.put("Message", "Hello there!");
        return hm;
    }

    @PostMapping(value = "/receipts/processes")
    public Object createUUID(@RequestBody Receipt receipt){
        HashMap<String, String> receiptHm = new HashMap<String, String>();
        Receipt processedReceipt = new Receipt();
        processedReceipt.setRetailer(receipt.getRetailer());
        processedReceipt.setPurchaseDate(receipt.getPurchaseDate());
        processedReceipt.setPurchaseTime(receipt.getPurchaseTime());
        processedReceipt.setItems(receipt.getItems());
        processedReceipt.setTotal(receipt.getTotal());
        receiptList.add(processedReceipt);
        UUID uuid = UUID.randomUUID();
        receiptHm.put("Testing UUID", uuid.toString());
        return receiptHm;
    }
}
