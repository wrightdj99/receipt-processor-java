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
        UUID uuid = UUID.randomUUID();
        receiptHm.put("Testing UUID", uuid.toString());
        receiptLibrary.put(uuid.toString(), receipt);
        System.out.println(receiptLibrary);
        return receiptHm;
    }
}
