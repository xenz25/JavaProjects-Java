package main_pack;

import java.util.Arrays;
import java.util.Scanner;

public class LexiSub {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.next();
		int k = scanner.nextInt();
		scanner.close();
		
		String[] collectionString = new String[s.length() - (k-1)];
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        welcometojava
        
        for(int i = 0; i < s.length() - (k-1); i++) {
            collectionString[i] = s.substring(i,i+k);
        }
        
        //bubble sort via compareTo()
        for(int i = 1; i < collectionString.length; i++) {
        	boolean flag = false;
        	for(int j = 0; j < collectionString.length - i; j++) {
        		if(collectionString[j].compareTo(collectionString[j+1]) > 0) {
        			//swap
        			String takenString = collectionString[j+1];
        			collectionString[j+1] = collectionString[j];
        			collectionString[j] = takenString;
        			flag = true;
        		}
        	}
        	if(!flag) break;
        }
        
        System.out.println(Arrays.toString(collectionString));
	}
}
