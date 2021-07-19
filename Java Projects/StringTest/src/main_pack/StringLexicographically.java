package main_pack;

import java.util.*;

public class StringLexicographically {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
        String A=sc.next().toLowerCase();
        String B=sc.next().toLowerCase();
        /* Enter your code here. Print output to STDOUT. */
        System.out.println(A.length() + B.length());
        
        
        String sample = (A.length() > B.length()) ? B : A; //choose the lesser length string
        sample = (A.length() == B.length()) ? A : sample; //if length is equal replace the sample with A
        String counter_part = (sample == A) ? B : A;
        
        for(int i = 0; i < sample.length(); i++) {
        	if(A == B) break;
        	if(Integer.valueOf(sample.charAt(i)) > Integer.valueOf(counter_part.charAt(i))) {
        		System.out.println((sample == A) ? "YES" : "NO");
        		break;
        	} else if(Integer.valueOf(sample.charAt(i)) == Integer.valueOf(counter_part.charAt(i))){
        		continue;
        	} else {
        		System.out.println((sample == A) ? "NO" : "YES");
        		break;
        	}
        }
        
        System.out.print(String.valueOf(A.charAt(0)).toUpperCase() + A.substring(1));
        System.out.println(" " + String.valueOf(B.charAt(0)).toUpperCase() + B.substring(1));
        
        System.out.println(A.compareTo(B));
	}

}
