package main_pack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class ReverseLinkedList {

    static LinkedList<String> reverseList(LinkedList<String> lst, int iter){
        if(iter == lst.size() - 1) return lst;
        lst.add(lst.size() - iter, lst.getFirst());
        lst.removeFirst();
        return reverseList(lst, iter + 1);


    }

    /*static String reverseList(LinkedList<String> lst){
        if(iter == lst.size() - 1) return lst;
        lst.add(lst.size() - iter, lst.getFirst());
        lst.removeFirst();
        return reverseList(lst, iter + 1);
    }*/

    public static void main(String[] args){
       LinkedList<String> list = new LinkedList<>();
       list.add("Volvo");
       list.add("BMW");
       list.add("Ford");
       list.add("Mazda");
       list.add("Mercedes");
       list.add("Ferrari");

       /*System.out.println("orig: " + list);
       LinkedList<String> newList = reverseList(list, 0);
       System.out.println("reversed: " + newList);*/

        int[] arr = {1,5,6,7,2,4};

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){-
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

       /* Iterator<String> it = list.iterator();

       while (it.hasNext()){
           System.out.println(it.next());
       }*/
    }

}

