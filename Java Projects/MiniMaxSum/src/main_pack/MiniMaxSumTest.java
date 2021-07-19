package main_pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MiniMaxSumTest {

	public static void main(String[] args) {
		int[] arr = {793810624, 895642170, 685903712, 623789054, 468592370};
		long total_element_sum = Arrays.stream(arr).sum();
        List<Long> sums = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            sums.add(total_element_sum - arr[i]);
        }
        System.out.println(Collections.min(sums) + " " + Collections.max(sums));
        String string = "hello";
        System.out.println(string.substring(0,2));

	}

}
