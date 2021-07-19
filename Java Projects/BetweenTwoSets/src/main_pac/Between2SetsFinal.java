package main_pac;

import java.util.ArrayList;
import java.util.List;

public class Between2SetsFinal {
    /*
    GCD is the greatest common factor of a given numbers
     - the greatest common factor of all the given number
     - Ex. GCD of all prime numbers is 1
     - Ex. GCD of all even is 2
    LCM is the least common multiple of a given numbers
     - the lowest number that can be divide to all the numbers without a remainder
     - the first occurrence of a common multiple of all number
     */

    static int getGCD(int a, int b){
        if(b == 0) return a;
        return getGCD(b, a%b);
    }

    static int getLCM(int a, int b){
        return (a*b)/getGCD(a, b);
    }

    static int findGCDorLCM(List<Integer> numList, int mode){
        int val = numList.get(0);
        for(int i = 1; i < numList.size(); i++){
            if(mode == 1) val = getLCM(numList.get(i), val);
            else val = getGCD(numList.get(i), val);
            if(val == 1) return val;
        }
        return val;
    }

    static int getInBetween(List<Integer> listA, List<Integer> listB){
        int lcm = findGCDorLCM(listA, 1); //LCM
        int gcd = findGCDorLCM(listB, 0); //GCD
        int multiples = lcm;
        int inBetweenCount = 0;
        while(multiples <= gcd){
            if(gcd%multiples == 0){
                inBetweenCount++;
            }
            multiples+=lcm;
        }
        return inBetweenCount;
    }

    public static void main(String[] args){
        List<Integer> a = new ArrayList<>(){{
            add(2);
            add(6);
        }};
        List<Integer> b = new ArrayList<>(){{
            add(24);
            add(36);
        }};

        int lcm = findGCDorLCM(a, 1); //LCM
        System.out.println("->" + lcm);
        System.out.println("->" + findGCDorLCM(a, 0));
        int gcd = findGCDorLCM(b, 0); //GCD
        System.out.println("->" + gcd);
        System.out.println("->" + findGCDorLCM(b, 1));
        int multiples = lcm;
        while(multiples <= gcd){
            if(gcd%multiples == 0){
                System.out.println(multiples);
            }
            multiples+=lcm;
        }

       // System.out.println(getInBetween(a, b));
        //System.out.println(getGCD(12, 16));

    }
}
