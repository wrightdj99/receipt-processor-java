package com.example.receiptprocessingchallengejava.HelperFunctions;

public class DollarAnalyzer {
    public static boolean dollarIsWhole(float dollarAmountParam){
        return dollarAmountParam == Math.floor(dollarAmountParam);
    }

    public static boolean dollarIsMultipleOf(float dollarAmountParam, float multipleParam){
        return dollarAmountParam % multipleParam == 0;
    }
}
