package main_pack;

import java.util.*;

public class SwapSimple {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter num 1 and num 2 separated by space: ");
		String[] numStrings = scanner.nextLine().split(" ");
		scanner.close();
		
		double num1 = Double.parseDouble(numStrings[0]);
		double num2 = Double.parseDouble(numStrings[1]);
		
		System.out.println("\nBefore Swapping:\nnum1: " + num1 + "\nnum2: " + num2);
		
		num1 = num1 + num2; num2 = num1 - num2; num1 = num1 - num2;
		
		System.out.println("\nAfter Swapping:\nnum1: " + num1 + "\nnum2: " + num2);
	}
}
