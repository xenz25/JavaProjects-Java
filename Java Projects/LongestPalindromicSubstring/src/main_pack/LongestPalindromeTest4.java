package main_pack;

public class LongestPalindromeTest4 {
    public static void main(String[] args){
        String s = "aabbaaba";
        int n = s.length();

        for(int iter = 1, incremenet = 1; iter < n; iter++, incremenet++){
            for(int col = 0, max = incremenet; col < n - incremenet; col++, max++){
                System.out.println(col + "," + max + " = " + s.substring(col, max));

            }
            System.out.println("----------------");
        }
    }
}
