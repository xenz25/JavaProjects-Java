package main_pack;

import java.math.BigInteger;
import java.util.*;

public class PascalTri {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter number of rows to print: ");
		int rows = scanner.nextInt();
		
		scanner.close();
		
		ArrayList<BigInteger> currentArrayList = new ArrayList<>();
		currentArrayList.add(new BigInteger("1"));
		ArrayList<BigInteger> savingArrayList = new ArrayList<>();
		
		for(int i = 0; i < rows; i++) {
			for(int space = 0; space < rows-i; space++) System.out.print(" "); //front spaces
			
			if(i == 0) {System.out.println("1");continue;}
			currentArrayList.add(0, new BigInteger("0")); currentArrayList.add(new BigInteger("0"));
			
			for(int j = 0; j < currentArrayList.size() - 1; j++) { 
				BigInteger consec_sum = currentArrayList.get(j).add(currentArrayList.get(j+1));
				savingArrayList.add(consec_sum);
				System.out.print(consec_sum + " ");
			}
			currentArrayList = new ArrayList<>(savingArrayList);
			savingArrayList = new ArrayList<>();
			System.out.println();
		}
	}
}
