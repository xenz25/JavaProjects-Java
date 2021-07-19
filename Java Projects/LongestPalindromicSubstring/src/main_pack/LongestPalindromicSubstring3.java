package main_pack;

public class LongestPalindromicSubstring3 {
    static boolean isPalindrome(String subString){
        for(int i = 0; i < subString.length() / 2; i++){
            if(subString.charAt(i) != subString.charAt(subString.length() -1 - i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        /*
        ALGORITHM
        Travel on the substrings with increasing substring length starting from 1st letter
        Example: aabaa
        0 first iteration 0 - 1{aa}, 1 - 2{ab}, 2 - 3{ba}, 3 - 4{aa} -> test each substring if palindrome
        1 second iteration 0 - 2{aab}, 1 - 3{aba}, 2 - 4{baa} -> test each substring if palindrome
        2 third iteration 0 - 3{aaba}, 1 - 4{abaa} -> test each substring if palindrome
        3 fourth iteration 0 - 4{aabaa}, -> test substring if palindrome

        if palindrome, get the length of substring, [end - start], if it is greater than the length of the previous
        detected palindrome length
        UPDATE the startIndex and endIndex for the longest detected substring.

        the outer max iteration = (1 -> string.length() - 1) - valid conditions: 1 < string.length()
        the inner max iteration is decreasing by 1 which can be referenced by the outer iteration value
         */

        //String s = "bbbaaaaabababaa";
        String s = "forgeeksskeegfor";
        //String s = "Geeks";
        //String s = "aabaa";
        int maxLength = 1;
        int startIndex = 0, endIndex = 1;

        for(int iter = 1, max = 2; iter < s.length(); iter++, max++){
            for(int start = 0, end = iter; start <= s.length() - max; start++, end++){
                if(isPalindrome(s.substring(start,end+1))){
                    if((end - start) > maxLength){
                        startIndex = start; endIndex = end + 1;
                    }
                }
            }
        }
        String palindrome = s.substring(startIndex, endIndex);
        System.out.println("Given String: " + s);
        System.out.println("The Longest Palindromic Substring: " + palindrome);
        System.out.print("Location: [" + startIndex + "," + endIndex + "] -> ");
        System.out.println(s.substring(0,startIndex) + "-[" + palindrome + "]-" + s.substring(endIndex));
    }
}
