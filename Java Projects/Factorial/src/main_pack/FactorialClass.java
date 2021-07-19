package main_pack;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.*;

public class FactorialClass {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = scanner.nextInt();
		scanner.close();
		
		System.out.print("The Factorial of " + num + " is: ");
		
		//using big integer to hold up more large numbers
		BigInteger fact = new BigInteger("1") ;
		for(int i = 1; i <= num; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		
		NumberFormat usFormat = NumberFormat.getInstance(Locale.US); //formatting output to readable format
		System.out.println(usFormat.format(fact));
	}
}
