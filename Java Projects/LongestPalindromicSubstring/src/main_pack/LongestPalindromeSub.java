package main_pack;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class LongestPalindromeSub {
    static String[] getPalindromicSubstring(String s, boolean printTable){
        int[][] dynamicTable = new int[s.length()][s.length()];

        //O(n)
        //filling up 1 to substring of each letter itself -> a letter is a palindrome
        for (int i = 0; i < dynamicTable.length; i++) {
            dynamicTable[i][i] = 1;
        }

        //0(n^2)
        for(int iter = 1, max = 2; iter < dynamicTable.length; iter++, max++){
            for(int row = 0, column = iter; row <= dynamicTable.length - max; row++, column++){
                dynamicTable[row][column] = isPalindrome(s.substring(row,column+1));
            }
        }

        //The longest palindromic substring is the one with the lowest row but higher column;
        int[] longestLocation = {dynamicTable.length-1,0};
        //will locate the substring location on dynamic table 0(n^2)
        for(int row = dynamicTable.length - 1; row >= 0; row--){
            //loops in reverse
            for(int col = dynamicTable[row].length - 1; col >= 0; col--){
                if((row != col) && (dynamicTable[row][col] == 1) && (row <= longestLocation[0] && col >= longestLocation[1])){
                    //System.out.println(row + " " + col);
                    longestLocation[0] = row;
                    longestLocation[1] = col;
                }
            }
        }
        String[] returnString = {s.substring(longestLocation[0], longestLocation[1] + 1), Arrays.toString(longestLocation)};
        if(printTable){
            System.out.println("  " + Arrays.toString(IntStream.range(0, dynamicTable.length).toArray()));
            for(int i = 0; i < dynamicTable.length; i++){
                System.out.println(i + " " + Arrays.toString(dynamicTable[i]));
            }
            System.out.println("The Longest Palindromic Substring: " + returnString[0]);
            System.out.println("Location: " + Arrays.toString(longestLocation));
        }
        return returnString;
    }

    static int isPalindrome(String subString){
        for(int i = 0; i < subString.length() / 2; i++){
            if(subString.charAt(i) != subString.charAt(subString.length() -1 - i)){
                return 0;
            }
        }
        return 1;
    }
    public static void main(String[] args){
        //try dynamic programming
        //String s = "aabaa";
        String s = "forgeeksskeegfor";
        //String s = "Geeks";
        getPalindromicSubstring(s, true);
    }
}
