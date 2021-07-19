package main_pck;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AppleAndOrange {

    public static void main(String[] args){
        int s = 7, t = 11;
        int a = 5, b = 15;
        int m = 3, n = 2;
        int[] apples = {-2, 2, 1}, oranges = {5, -6};

        System.out.println(IntStream.of(apples).parallel()
                .filter(apple -> (apple + a) >= s && (apple + a) <= t).count());
        System.out.println(IntStream.of(oranges).parallel()
                .filter(orange -> (orange + b) >= s && (orange + b) <= t).count());

        int[] arr1 = IntStream.range(1,10).parallel().filter(item -> item % 2 == 0).toArray();
        System.out.println(Arrays.toString(arr1));
    }
}
