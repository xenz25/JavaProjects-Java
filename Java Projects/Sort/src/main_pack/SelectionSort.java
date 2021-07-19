package main_pack;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		long start = System.nanoTime();
		//int[] list = {2,5,4,3,2,7,1};
		//int[] list = {1,2,3,4,5,6};
		int[] list = {2,7,4,1,5,3};
		
		
		
		for(int i = 0; i < list.length - 1; i++) {
			boolean flag = false;
			int min_index = i;
			for(int j = i + 1; j < list.length; j++) {
				if(list[j] < list[min_index]) {
					min_index = j;
					flag = true;
				}
			}
			if(!flag) break;
			int taken = list[min_index];
			list[min_index] = list[i];
			list[i] = taken;
		}
		
		System.out.println(Arrays.toString(list));
		long end = System.nanoTime();
		System.out.println("Execution time (nano sec): " + (end-start));

	}

}
