package com.example.receiptprocessingchallengejava.HelperFunctions;
import java.util.Date;
//The DateAnalyzer class just has one helper method that checks whether a day is odd.
public class DateAnalyzer {
    public static boolean dayIsOdd(Date dateParam){
        int day = dateParam.getDay();
        return day % 2 == 0;
    }
}
