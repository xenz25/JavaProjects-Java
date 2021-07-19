package main_pack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IdentificationPair {

    static int[] merge(int[] arr1, int[] arr2){
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] <= arr2[j]){
                result[k] = arr1[i];
                i++;
            } else {
                result[k] = arr2[j];
                j++;
            }
            k++;
        }
        System.out.println("--> " + Arrays.toString(result));
        while(i < arr1.length){
            result[k] = arr1[i];
            i++;
            k++;
        }
        while(j < arr2.length){
            result[k] = arr2[j];
            j++;
            k++;
        }
        return result;
    }

    public static void main(String[] args){

        //int[] itemsMain = {1,2,2,3};
        //int[] itemsMain = {0,1,2,3,0,4};


        int[] ar1 = {0,1};
        int[] ar2 = {2,3};
        int[] ar3 = {0,4};

        int[] itemsMain1 = merge(ar1, ar2);
        int[] itemsMain = merge(itemsMain1, ar3);

        //int[] itemsMain = {0,1,2,3,0,4};

        Arrays.sort(itemsMain);
        Collections.sort(new ArrayList<Integer>());
        System.out.println(Arrays.toString(itemsMain));

        List<Integer> complete = IntStream.range(0, itemsMain[itemsMain.length-1]+1).parallel().boxed().collect(Collectors.toList());
        System.out.println(complete);

        int intersections = 0;


        for(Integer item : complete){
            long occurrence = IntStream.of(itemsMain).filter(i -> i == item).parallel().count();
            System.out.println(item + " -> " + occurrence + " -> pairs: " + (occurrence/2) + " intersect");
            intersections+=(occurrence/2);
        }

        System.out.println("Detected Intersection: " + intersections);
        if(intersections == 0){
            int pairs = Math.floorDiv(complete.size(),2);
            int excess = complete.size() % pairs;
            System.out.println((int) Math.pow(2,pairs)+excess);
        } else {
            int unique = complete.size() - intersections*3;
            System.out.println(unique*intersections*3);
        }


       /* for(int i = 0; i < items.length; i++){
            int currentItem = items[i];
            int count = 1;
            while(i+1 < items.length && currentItem == items[i + 1]){
                count++; i++;
            }
            intersections += (count/2);
            System.out.println(currentItem + " -> " + count + " -> pairs: " + (count/2) + " intersect");
        }
        System.out.println("Detected Intersection: " + intersections + " which is: ");*/

    }
}
