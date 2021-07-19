package main_pack;

public class IntToRoman {

    static String getRoman(int num){
        if(num > 3000) return "Cannot Convert Number: max limit reached.";
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num%10000 / 1000] + hundreds[num%1000 / 100] + tens[num%100 /10] + ones[num%10];
    }

    public static void main(String[] args){
        System.out.println(getRoman(3526));
    }
}
