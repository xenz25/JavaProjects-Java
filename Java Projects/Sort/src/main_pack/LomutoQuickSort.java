package main_pack;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LomutoQuickSort {
    static void printArr(int[] arr){
        for(int item : arr)
            System.out.print(item + " ");
        System.out.println();
    }

    static int partition(int[] array, int startIndex, int endIndex){
        int pivot = array[endIndex];
        int pivotIndex = startIndex;

        for(int i = startIndex; i <= endIndex; i++){
            if(array[i] < pivot){
                int temp = array[pivotIndex];
                array[pivotIndex] = array[i];
                array[i] = temp;
                pivotIndex+=1;
            }
        }
        array[endIndex] = array[pivotIndex];
        array[pivotIndex] = pivot;
        return pivotIndex;
    }

    static void quickSort(int[] array, int startIndex, int endIndex){
        if(startIndex < endIndex){
            int pivotIndex = partition(array, startIndex, endIndex);
            printArr(array);
            quickSort(array, startIndex, pivotIndex-1); //left
            quickSort(array, pivotIndex+1, endIndex); //right
        }
    }

    public static void main(String[] args){
        //39 9 81 45 9 27 72 18
        //5 8 1 3 7 9 2
        //1 3 9 8 2 7 5

        Scanner sc = new Scanner(System.in);
        String[] elements = sc.nextLine().trim().split(" ");
        int[] unsorted = Arrays.stream(elements).parallel()
                .mapToInt(Integer::parseInt).toArray();
       /* System.out.println(partition(unsorted, 0, unsorted.length-1));
        System.out.println(Arrays.toString(unsorted));*/
        quickSort(unsorted, 0, unsorted.length-1);
    }
}
