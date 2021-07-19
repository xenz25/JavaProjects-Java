package main_pack;

import java.util.*;

public class LongestPalindromeSub2Online{

    // Function to print a subString str[low..high]
    static void printSubStr(String str, int low, int high)
    {
        for (int i = low; i <= high; ++i)
            System.out.print(str.charAt(i));
    }

    // This function prints the
    // longest palindrome subString
    // It also returns the length
    // of the longest palindrome
    static int longestPalSubstr(String str)
    {
        // get length of input String
        int n = str.length();

        // All subStrings of length 1
        // are palindromes
        int maxLength = 1, start = 0;

        // Nested loop to mark start and end index
        for (int row = 0; row < str.length(); row++) {
            for (int j = row; j < str.length(); j++) {
                int flag = 1;

                // Check palindrome
                for (int k = 0; k < (j - row + 1) / 2; k++)
                    if (str.charAt(row + k) != str.charAt(j - k)) {
                        flag = 0;
                        break;
                    }
                //if Palindrome
                if (flag!=0 && (j - row + 1) > maxLength) {
                    start = row;
                    maxLength = j - row + 1;
                }
            }
        }

        System.out.print("Longest palindrome subString is: ");
        printSubStr(str, start, start + maxLength - 1);

        // return length of LPS
        return maxLength;
    }

    // Driver Code
    public static void main(String[] args)
    {
        String str = "aabaa";
        //String str = "forgeeksskeegfor";
        //String str = "Geeks";
        System.out.print("\nLength is: " + longestPalSubstr(str));
    }
}