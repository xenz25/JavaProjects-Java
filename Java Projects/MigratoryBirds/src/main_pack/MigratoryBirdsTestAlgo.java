package main_pack;

import java.util.*;

public class MigratoryBirdsTestAlgo {
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		arr.add(5);
		arr.add(4);
		arr.add(3);
		arr.add(2);
		arr.add(2);
		arr.add(3);
		arr.add(4);
		
//		//algo not efficient Time Limit Exceed
//		int min = arr.get(0);
//		int max = 0;
//		for(int i = 0; i < arr.size()-1; i++) {
//			int temp_occurence = 0;
//			int current = arr.get(i);
//			for(int j = i+1; j < arr.size(); j++) {
//				if(current == arr.get(j)) {
//					temp_occurence++;
//				}
//			}
//			if(temp_occurence == max) min = (current < min) ? current : min;
//			else if(temp_occurence > max) {
//				min = current;
//				max = temp_occurence;
//			}
//		}
		
		//algo not efficient Time Limit Exceed -> add already checked list to prevent checking again
		//works perfectly
		Set<Integer> set_checkedIntegers = new HashSet<>();
		
		int min = arr.get(0);
		int max = 0;
		for (int i = 0; i < arr.size() - 1; i++) {
			int temp_occurence = 0;
			int current = arr.get(i);
			if(set_checkedIntegers.contains(current)) continue; //skip checking
			for (int j = i + 1; j < arr.size(); j++) {
				if (current == arr.get(j)) {
					temp_occurence++;
				}
			}
			set_checkedIntegers.add(current);
			if (temp_occurence == max)
				min = (current < min) ? current : min;
			else if (temp_occurence > max) {
				min = current;
				max = temp_occurence;
			}
		}
        
		System.out.println(min);
		
	}
}
