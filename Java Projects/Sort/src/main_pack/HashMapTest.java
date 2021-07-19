package main_pack;

import java.util.*;

public class HashMapTest {

    public static void main(String[] args){
        List<Integer> myList = new ArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        Map<Integer, ArrayList<Integer>> myHash = new HashMap<>();

        for(int i = 0; i < 10; i++){
            Collections.shuffle(myList);
            myHash.put(i, new ArrayList<>(myList));
        }

        for(Map.Entry<Integer, ArrayList<Integer>> items : myHash.entrySet()){
            System.out.println(
                    items.getValue()
            );
        }
    }
}
