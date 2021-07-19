package main_pack;

import java.math.BigInteger;
import java.util.*;

public class FloydsTri {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of rows: ");
		long rows = scanner.nextInt();
		scanner.close();
		
		System.out.println(rows + " rows of Floyd's Triangle:");
		
		BigInteger current = new BigInteger("1");
		for(long i = 1; i <= rows; i++) {
			for(long j = 0; j < i; j++) {
				System.out.print(current.intValueExact() + " ");
				current = current.add(BigInteger.valueOf(1));
			}
			System.out.println();
		}
	}
}
