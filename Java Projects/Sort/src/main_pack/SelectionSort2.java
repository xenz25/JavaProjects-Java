package main_pack;

import java.util.ArrayList;
import java.util.List;

public class SelectionSort2 {

    public static void main(String[] args){
        List<Integer> arr = new ArrayList<>(){{
            add(14);
            add(33);
            add(27);
            add(10);
            add(35);
            add(19);
            add(42);
            add(44);
        }};

        for(int i = 0; i < arr.size(); i++){
            int currentVal = arr.get(i);
            int minValPos = i;
            System.out.println(currentVal + " = " + minValPos);
            while(minValPos < arr.size()-1){
                if(arr.get(minValPos+1) < currentVal){
                    break;
                }
                System.out.println("Incremented: " + minValPos);
                minValPos+=1;
            }
            System.out.println("Index: " + minValPos);
            if(minValPos!=i){
                arr.set(i, arr.get(minValPos));
                arr.set(minValPos, currentVal);
            }
            System.out.println(arr);

        }
    }
}
