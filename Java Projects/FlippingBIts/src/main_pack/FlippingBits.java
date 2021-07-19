package main_pack;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class FlippingBits {
    public static void main(String[] args){
         long number= 12;
         long[] bits = new long[32];
         Arrays.fill(bits,1);

        int bitc = 0;
        long dec = 0, mul = 1;
        while (number != 0) {
            bits[bitc++] = (number % 2) == 1 ? 0 : 1;
            number /= 2;
        }
        for (long bit : bits) {
            if (bit == 1) dec += mul;
            mul*=2;
        }
        System.out.println("\n" + Arrays.toString(bits));
        System.out.print(dec);

        //simplest algo
        /*BigInteger integer = new BigInteger("4294967295");
        long max = integer.longValueExact();
        System.out.print(max ^ number);*/ //using XOR gate
    }
}
