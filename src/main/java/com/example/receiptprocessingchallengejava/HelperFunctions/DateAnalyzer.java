package com.example.receiptprocessingchallengejava.HelperFunctions;

import java.util.Date;

public class DateAnalyzer {
    public static boolean dayIsOdd(Date dateParam){
        int day = dateParam.getDay();
        return day % 2 == 0;
    }
}
