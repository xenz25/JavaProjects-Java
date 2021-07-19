package main_pack;

import java.math.BigInteger;

public class FactorialByReccursionLarge {
    //impossible
    static BigInteger mul(BigInteger num){
        if(num.intValueExact() <= 1) return BigInteger.valueOf(1);
        return num.multiply(num);
    }

    public static void main(String[] args){
        int number = 5;
        System.out.println(mul(new BigInteger(String.valueOf(number))));
    }
}
