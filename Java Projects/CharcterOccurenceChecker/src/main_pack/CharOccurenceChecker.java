package main_pack;

import java.util.Arrays;

public class CharOccurenceChecker {

	public static void main(String[] args) {
		int[] vector = new int[26];
		Arrays.fill(vector, 0); //init all contents to zero
		char look_up = 'c';
		String in_String = "chedcfcwc";
		
		for(int i = 0; i < in_String.length(); i++) {
			vector[in_String.charAt(i)-'a']++; //just update increment all appearing letters
		}
		
		System.out.println(vector[look_up-'a']); //look up for char
	}

}
