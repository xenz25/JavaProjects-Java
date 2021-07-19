package main_pack;

public class AnagramCheck {
	public static void main(String[] args) {
		//case sensitive
		String a = "bbcc";
		String b = "dabc";
		
		//non case sensitive
		//String a = "mama".toLowerCase();
		//String b = "mama".toLowerCase();
		
		boolean isAnagram = !((a.length() > b.length()) || (a.length() < b.length()));
		int char_sumA = 0, char_sumB = 0;
		        
		if (isAnagram) {
			// same length of string
			// if anagram the sum of all string character decimal equivalent
			// must be equal
			for (int i = 0; i < a.length(); i++) {
				char_sumA-=Character.getNumericValue(a.charAt(i));
                char_sumB-=Character.getNumericValue(b.charAt(i));
			}
			isAnagram = (char_sumA == char_sumB);
			System.out.println(char_sumA + " " + char_sumB);
		}
		System.out.println(isAnagram ? "is Anagram" : "not Anagram");       
	}
}
