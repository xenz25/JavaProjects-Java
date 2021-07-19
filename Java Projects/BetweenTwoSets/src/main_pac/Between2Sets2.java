package main_pac;

import java.util.ArrayList;
import java.util.List;

public class Between2Sets2 {

    static int getGcd(int a, int b){
        if(b == 0) return a;
        return getGcd(b, a%b);
    }

    //18 24 = 52
    static int getLcm1(int a, int b){
        int tempA = a, tempB = b;
        if(a < b){
            //swap
            tempA+=b;
            tempB = tempA-b;
            tempA -= tempB;
        }
        if(tempA%tempB == 0) return b; //6
        return getLcm(b, a%b); //18 6
    }

    static int getLcm(int a, int b){
        return (a*b)/getGcd(a,b);
    }

    static int findGCD(List<Integer> numList){
        int res = numList.get(0);
        for(int i = 1; i < numList.size(); i++){
            res = getGcd(numList.get(i), res);
            if(res == 1) return res;
        }
        return res;
    }

    static int findLCM(List<Integer> numList){
        int res = numList.get(0);
        for(int i = 1; i < numList.size(); i++){
            res = getLcm(numList.get(i), res);
            if(res == 1) return res;
        }
        return res;
    }

    static String getPrimeFactors(int num){
        StringBuilder s = new StringBuilder();
        for(int i = 2; i <= Math.sqrt(num); i++){
            int i_occur = 0;
            if(num%i == 0){
                while(num%i == 0){
                    num = num/i;
                    i_occur++;
                }
                s.append(i).append("^").append(i_occur).append(" ");
            }
        }
        if(num!=1) s.append(num).append("^").append(1).append(" ");
        return s.toString().strip();
    }

    static String getFactors(int num){
        StringBuilder s = new StringBuilder();
        for(int i = 1; i <= Math.sqrt(num); i++){
            if(num%i == 0){
                s.append(i).append(" ");
                if(i != Math.sqrt(num))
                    s.append(num/i).append(" ");
            }
        }
        return s.toString().strip();
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

        System.out.println(getFactors(12));

        /*int lcm = findLCM(a);
        int gcd = findGCD(b);
        int counter = lcm;
        int dig = 0;
        while(counter <= gcd){
            if(gcd%counter == 0){
                dig++;
            }
            counter+=lcm;
        }
        System.out.println(dig);*/

    }
}
