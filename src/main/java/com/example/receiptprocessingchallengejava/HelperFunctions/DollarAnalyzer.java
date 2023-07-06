package com.example.receiptprocessingchallengejava.HelperFunctions;
/*If we want to write any helper methods that have to do with dollar amounts, they go here.*/
public class DollarAnalyzer {
    //Checks if a dollar amount is whole
    public static boolean dollarIsWhole(float dollarAmountParam){
        return dollarAmountParam == Math.floor(dollarAmountParam);
    }
    //Checks if a dollar is a multiple of a given number/decimal. This approach (not just hardcoding 0.25 in) also allows
    //us greater flexibility to change the multiple we want to check against in the future.
    public static boolean dollarIsMultipleOf(float dollarAmountParam, float multipleParam){
        return dollarAmountParam % multipleParam == 0;
    }
}
