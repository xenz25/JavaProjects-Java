package main_pack;

import java.util.Arrays;

public class Permutation {
	
	public static void swapPositions(int[] arr, int index1, int index2) {
		int taken = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = taken; 
	}
	
	public static void printPermutations(int[] array, int current_index) {
		if(current_index == array.length-1) {
			//if outside the array
			System.out.println(Arrays.toString(array));
			return;
		}
		
		for(int i = current_index; i < array.length; i++) {
			swapPositions(array, i, current_index);
			printPermutations(array, current_index+1);
			swapPositions(array, i, current_index);
		}
	}
	
	public static void main(String[] args) {
		int[] set = {3,1,2};
		printPermutations(set, 0);
	}
}
