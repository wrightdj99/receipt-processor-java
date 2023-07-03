package com.example.receiptprocessingchallengejava.Integration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.*;
@RestController
public class ReceiptRestController {
    @GetMapping(value = "/testing")
    public String testCall(){
        return "Hello! I'm the test method!";
    }
}
