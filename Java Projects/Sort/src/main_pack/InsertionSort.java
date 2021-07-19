package main_pack;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort {

    static void printArr(List<Integer> arr){
        for(Integer i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>(){{
            add(2);
            add(1);
            add(3);
            add(1);
            add(2);
        }};

        int counter = 0;

        for(int i = 1; i < arr.size(); i++){
            int val = arr.get(i);
            int hole = i;

            while(hole > 0 && arr.get(hole-1) > val){
                arr.set(hole, arr.get(hole-1));
                counter++;
                arr.set(hole-1, val); //comment to view shifting
                hole-=1;
                printArr(arr);
            }
           // arr.set(hole, val); //uncomment to make shifting work
        }
        printArr(arr);
        System.out.println(counter);
    }

}
