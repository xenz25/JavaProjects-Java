package main_pac;

import java.util.*;


public class Between2Sets {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String[] lengths = scanner.nextLine().trim().split(" ");
		
		String[] aStrings = scanner.nextLine().trim().split(" ");
		String[] bStrings = scanner.nextLine().trim().split(" ");
		
		scanner.close();
		List<Integer> a_ints = new ArrayList<>();
		List<Integer> b_ints = new ArrayList<>();
		
		
		for (int i = 0; i < aStrings.length; i++) {
            int brrItem = Integer.parseInt(aStrings[i]);
            a_ints.add(brrItem);
        }
		
		for (int i = 0; i < bStrings.length; i++) {
            int brrItem = Integer.parseInt(bStrings[i]);
            b_ints.add(brrItem);
        }
		
		if((aStrings.length == Integer.parseInt(lengths[0])) && (bStrings.length == Integer.parseInt(lengths[1]))) {
			int max_a = Collections.max(a_ints);
			int max_b = Collections.max(b_ints);
			int f_max = (max_a > max_b) ? max_a : max_b;
			
			int min_a = Collections.min(a_ints);
			int min_b = Collections.min(b_ints);
			int f_min = (max_a > max_b) ? max_b : max_a;
			
			
			for(int i = f_min; i <= f_max; i++) {
				for(int current_number : a_ints) {
						if(i%current_number == 0) {
							for(int number2 : b_ints) {
								if(i%number2 == 0) {
									System.out.println(i);
								}
							}
						}
				}
			}
			
		}

	}

}
