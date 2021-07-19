package main_pack;

import sample.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class CandiesMinimal {

    public static void main(String[] args){
        /*List<Integer> rates = new ArrayList<>(){{
            add(4);
            add(6);
            add(4);
            add(5);
            add(6);
            add(2);
        }};*/

        List<Integer> rates = new ArrayList<>(){{
            add(2);
            add(4);
            add(2);
            add(6);
            add(1);
            add(7);
            add(8);
            add(9);
            add(2);
            add(1);
        }};

        /*List<Integer> rates = new ArrayList<>(){{
            add(2);
            add(4);
            add(3);
            add(5);
            add(2);
            add(6);
            add(4);
            add(5);
        }};*/

        List<Integer> right = new ArrayList<>(rates);
        List<Integer> left = new ArrayList<>(rates);
        Collections.fill(left, 1);
        Collections.fill(right, 1);

        for(int i = 1; i < rates.size(); i++){
            if(rates.get(i) > rates.get(i-1)){
                left.set(i, left.get(i-1)+1);
            }
        }

        for(int i = 0; i < rates.size()-1; i++){
            if(rates.get(i) > rates.get(i+1)){
                left.set(i, Math.max(left.get(i), right.get(i+1)+1));
                right.set(i, right.get(i+1)+1);
                //left.set(i, left.get(i)+right.get(i));
            }
        }

        System.out.println(left);
        System.out.println(right);

        /*long sum = 0;
        for(int i = 0; i < rates.size(); i++){
            sum += Math.max(left.get(i), right.get(i));
        }

        System.out.println(sum);*/
        long sum = left.stream().reduce(0, Integer::sum);
        System.out.println();
    }
}
