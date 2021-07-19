package main_pack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SieveOfEratosthenes {
    //do by recursion
    static List<Integer> getPrimes(List<Integer> primeList, List<Integer> testList){
        if(testList.isEmpty()) return primeList;
        int num = testList.get(0); //copy test number
        testList.remove(0); //remove test number
        primeList.add(num); //set number as prime
        return getPrimes(primeList, testList.stream().parallel().filter(item -> item % num != 0).collect(Collectors.toList()));
    }

    public static void main(String[] args){
        int range = 50;
        List<Integer> testList = IntStream.range(2,range+1).boxed().collect(Collectors.toList());
        System.out.println(getPrimes(new ArrayList<>(), testList).toString());
    }
}
