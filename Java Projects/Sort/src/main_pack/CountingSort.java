package main_pack;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CountingSort {

    static List<Integer> countingSort(int[] arr, int max){
        int[] mapper = new int[max+1];
        List<Integer> sorted = new ArrayList<>();

        for(int item : arr)
            mapper[item]++;

        for(int i = 0; i < mapper.length; i++){
            for (int j = 0; j < mapper[i]; j++)
                sorted.add(i);
        }

        return sorted;
    }

    public static void main(String[] args){
        //100
        //63 25 73 1 98 73 56 84 86 57 16 83 8 25 81 56 9 53 98 67 99 12 83 89 80 91 39 86 76 85 74 39 25 90 59 10 94 32 44 3 89 30 27 79 46 96 27 32 18 21 92 69 81 40 40 34 68 78 24 87 42 69 23 41 78 22 6 90 99 89 50 30 20 1 43 3 70 95 33 46 44 9 69 48 33 60 65 16 82 67 61 32 21 79 75 75 13 87 70 33
        //7
        //19 10 12 10 24 25 22
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine().trim());
        String[] elements = sc.nextLine().trim().split(" ");
        int[] unsorted = Arrays.stream(elements).parallel()
                .mapToInt(Integer::parseInt).toArray();
        System.out.println(countingSort(unsorted, Arrays.stream(unsorted).max().getAsInt()));
    }
}
