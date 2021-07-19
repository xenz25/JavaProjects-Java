package main_pack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MakingAnagrams {

	public static void main(String[] args) {
		//String a = "cdce", b = "abcde";
		String a = "cde", b = "abcdce"; 
		
		int[] vector = new int[26]; char base = 'a';
		Arrays.fill(vector, 0); //init all contents to zero
		
		//a string
		for(int i = 0; i < a.length(); i++) {
			vector[a.charAt(i)-base]++; //just update increment all appearing letters
		}
		
		//b string
		for (int i = 0; i < b.length(); i++) {
			vector[b.charAt(i)-base]--; // just update increment all appearing letters
		}
		
		int deletion = 0;
		for(int occurence : vector) deletion+= Math.abs(occurence);
		System.out.println(deletion);
		
	}

}
