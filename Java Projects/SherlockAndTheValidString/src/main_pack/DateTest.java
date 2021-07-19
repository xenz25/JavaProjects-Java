package main_pack;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateTest {
    static String getDateString(Date date){
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-dd-MMMM");
        return myFormat.format(date);
    }

    public static void main(String[] args){
        /*Calendar myDate = Calendar.getInstance();
        myDate.set(2011, Calendar.JANUARY, 1);
        System.out.println(getDateString(myDate.getTime()));*/

        int x = 1256;
        System.out.print((x % 1000)/100);
    }
}
