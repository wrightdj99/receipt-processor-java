package com.example.receiptprocessingchallengejava.HelperFunctions;
//A class with one method that returns the trimmed length of a string. Very helpful indeed when working with item descriptions, as well as retailer names!
public class CharAnalyzer {
    public static int charCounterHelper(String paramString){
        paramString = paramString.replaceAll("[^A-Za-z0-9]", "");
        return paramString.length();
    }
}
