package com.example.receiptprocessingchallengejava.HelperFunctions;
import java.time.LocalTime;

/*Helper method timeIsBetween takes a before and after time and checks if the given time (purchaseTime) is between
* those two times.*/
public class TimeAnalyzer {
    public static boolean timeIsBetween(String before, String after, String time){
        LocalTime b = LocalTime.parse(before);
        LocalTime a = LocalTime.parse(after);
        LocalTime processedTime = LocalTime.parse(time);
        return processedTime.isBefore(b) && processedTime.isAfter(a);
    }
}
