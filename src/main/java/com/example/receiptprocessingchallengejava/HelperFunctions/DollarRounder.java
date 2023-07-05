package com.example.receiptprocessingchallengejava.HelperFunctions;

public class DollarRounder {
    public static boolean dollarRounderHelper(float dollarAmountParam){
        return dollarAmountParam == Math.floor(dollarAmountParam);
    }
}
