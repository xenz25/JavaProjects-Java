package main_pack;

import java.util.*;
import java.util.stream.*;

public class QuickSort1 {

    static List<Integer> inPlaceDivision(List<Integer> list, int leftEnding, int rightStarting){
        if(list.size() <= 1) return list;
        int pivotPos = list.size() - 1;
        int pivot = list.get(pivotPos);
        int i = 0;

        while(i != pivotPos){
            int curr = list.get(i);
            if(i == pivotPos-1 && list.get(i) > pivot){
                list.set(pivotPos-1, pivot);
                list.set(pivotPos, curr);
                pivotPos -= 1;
                break;
            }
            if(curr >= pivot){
                int replacement = list.get(pivotPos-1);
                list.set(i, replacement);
                list.set(pivotPos, curr);
                list.set(pivotPos-1, pivot);
                pivotPos -= 1;
                continue;
            }
            i++;
        }

        int leftMax = pivotPos - 1;
        int rightMax = pivotPos + 1;

        System.out.println(list + "Left: 0 - " + leftMax + " Right: " + rightMax + " - " + (list.size()-1));
        return list;
    }

    static void printArr(List<Integer> arr){
        for(Integer item : arr)
            System.out.print(item + " ");
        System.out.println();
    }

    static List<Integer> quickSort(List<Integer> currentArr){
        if(currentArr.size() <= 1) {
            return currentArr;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int pivot = currentArr.get(0);

        for(int i = 1; i < currentArr.size(); i++){
            int currItem = currentArr.get(i);
            if(currItem < pivot) left.add(currItem);
            else right.add(currItem);
        }



        if(!left.isEmpty()) {
            left = quickSort(left);
            if(left.size() > 1)
                printArr(left);
        }
        if(!right.isEmpty()) {
            right = quickSort(right);
            if(right.size() > 1)
                printArr(right);
        }

        //System.out.println(left + " " + right);

        List<Integer> sorted = new ArrayList<>(left);
        sorted.add(pivot);
        sorted.addAll(right);
        return sorted;
    }

    /*static int[] quickSort(int[] unsorted){
        if(unsorted.length <= 1) return unsorted;

        int[] left = new int[unsorted.length];
        int[] right = new int[unsorted.length];

        int pivot = unsorted[0];

        int currLeft = 0;
        int currRight = 0;

        for(int item : unsorted){
            if(item < pivot) {
                left[currLeft] = item;
                currLeft+=1;
            } else {
                right[currRight] = item;
                currRight+=1;
            }
        }
        if (currLeft != 0) quickSort(left);
        if(currRight != 0) quickSort(right);

        //merge
        int[] sorted = new int[left.length + right.length + 1];
        int current = 0;
        for(; current < left.length; current+=1){
            sorted[current] = left[current];
        }
        sorted[current++] = pivot;
        for(; current < right.length; current+=1){
            sorted[current] = right[current];
        }
        return sorted;
    }*/

    public static void main(String[] args){
        /*List<Integer> unsorted = new ArrayList<>(){{
           add(3);
           add(7);
           add(8);
           add(5);
           add(2);
           add(1);
           add(9);
           add(5);
           add(4);
        }};*/

        /*List<Integer> unsorted = new ArrayList<>(){{
           add(3);
           add(1);
        }};*/
        //39 9 81 45 9 27 72 18
        //5 8 1 3 7 9 2

        /*int[] arrEmpty = new int[2];
        arrEmpty[0]++;
        System.out.println(arrEmpty[0]);*/

        //System.out.println(Arrays.toString(quickSort(new int[]{39,9,81,45,9,27,72,18})));

        //System.out.println(unsorted);
        //inPlaceDivision(unsorted);

        Scanner sc = new Scanner(System.in);
        String[] elements = sc.nextLine().trim().split(" ");
        List<Integer> unsorted = Arrays.stream(elements)
                .parallel()
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());

        printArr(quickSort(unsorted));

    }
}
