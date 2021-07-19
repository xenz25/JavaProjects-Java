package main_pack;

import java.util.HashMap;

public class RomanToInt {

    static int getInt(String roman){
        HashMap<Character, Integer> valMap = new HashMap<>(){{
           put('I', 1);
           put('V', 5);
           put('X', 10);
           put('L', 50);
           put('C', 100);
           put('D', 500);
           put('M', 1000);
        }};
        int previousValue = 0;
        int number = 0;
        for (char let : roman.toCharArray()) {
            int current = valMap.get(let);
            if(current > previousValue && previousValue != 0) number += current - 2*previousValue;
            else number+=current;
            previousValue = current;
        }
        return number;
    }

    public static void main(String[] args){
        System.out.print(getInt("CXXV"));
    }
}
