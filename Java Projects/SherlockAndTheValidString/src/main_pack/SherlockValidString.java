package main_pack;

import java.util.*;

public class SherlockValidString {
	
	/*
	 * Sherlock considers a string to be valid if all characters of the 
	 * string appear the same number of times. It is also valid if he 
	 * can remove just  character at  index in the string, and the 
	 * remaining characters will occur the same number of times. Given 
	 * a string , determine if it is valid. If so, return YES, 
	 * otherwise return NO.
	 */

	public static void main(String[] args) {
		String s = "abbccc";
		// TODO Auto-generated method stub
		int[] vector = new int[26];
        Arrays.fill(vector, 0);
        
        Set<Character> cheCharacters = new HashSet<>();
        
        for(int i = 0; i < s.length(); i++){
        	char current = s.charAt(i);
        	++vector[current-'a'];
        	if(!cheCharacters.contains(s.charAt(i))) cheCharacters.add(current);
        }
        
        System.out.println(Arrays.toString(vector));
        
        int sum_of_occurence = Arrays.stream(vector).sum();
        
        System.out.println("--> " + sum_of_occurence);
        
        System.out.println((sum_of_occurence % cheCharacters.size() == 0)||
                (sum_of_occurence % cheCharacters.size() == 1) ? "YES" : "NO");



	}

}
