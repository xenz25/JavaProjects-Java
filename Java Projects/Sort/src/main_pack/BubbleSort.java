package main_pack;

import java.util.Arrays;


public class BubbleSort {

	public static void main(String[] args) {
		long start = System.nanoTime();
		int[] list = {2,5,4,3,2,7,1};
		//int[] list = {2,7,4,1,5,3};
		//int[] list = {1,2,3,4,5,6};
		
		for(int x = 1; x <= list.length; x++) {
			boolean flag = false;
			for(int i = 0; i < list.length - x; i++) {
				if(list[i] > list[i+1]) {
					int taken = list[i+1];
					list[i+1] = list[i];
					list[i] = taken;
					flag = true;
				}
			}
			if(!flag) break;
		}
		
		System.out.println(Arrays.toString(list));
		long end = System.nanoTime();
		System.out.println("Execution time (nano sec): " + (end-start));
	}

}
