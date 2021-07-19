
public class PalindromeCheck {

	public static void main(String[] args) {
		String string = "nasabayabasan".toLowerCase();
		
		//no reversal of string check simultaneously only
		
		int max_iter = string.length()/2;
		if(string.length() % 2 != 0) max_iter = (string.length() - 1)/2;
		
		int match_length = 0;
		for(int i = 0; i < max_iter; i++) {
			if(string.charAt(i) == string.charAt((string.length() - 1 - i))) {
				match_length++;
			}
		}
		if(match_length == max_iter) System.out.println("Yes");
		else System.out.println("No");
	}

}
