package main_pck;

import java.util.*;

public class Armstrong {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter min and max range separated by space: ");
		String[] num_range = sc.nextLine().split(" ");
		sc.close();
		
		System.out.println("Armstrong Number(s) from " + num_range[0] + " to " + num_range[1]);
		
		for(int i = Integer.parseInt(num_range[0]); i <= Integer.parseInt(num_range[1]); i++){
		    int sum = 0;
    		String string_val = String.valueOf(i);
    		for(int j = 0; j < string_val.length(); j++){
    		   sum+=Math.pow(string_val.charAt(j) - '0',string_val.length());
    		}
    		if(sum == i){
    		    System.out.println(i);
    		}
		}
	}
}
