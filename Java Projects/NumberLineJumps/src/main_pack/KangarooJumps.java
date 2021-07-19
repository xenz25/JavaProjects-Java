package main_pack;

public class KangarooJumps {

    public static void main (String[] args){
        int x1 = 1817, v1 = 9931;
        int x2 = 8417, v2 = 190;

        //43 2 70 2

        /*int x1 = 43, v1 = 2;
        int x2 = 70, v2 = 2;*/

        /*int x1 = 2, v1 = 1;
        int x2 = 1, v2 = 2;*/

        /*
        1.V1 and V2 must not be equal
        2 to predict the meeting point count of jumps we use the formula
        jumps to meet = (x2 - x1) / (v1 - v2)
        jumps to meet must be:
        1. a positive number greater than 1
        2. not a floating point number
        then apply the jumps to meet to the formula:
        valueA = x1 + (v1 + jumps to meet)
        valueB = x1 + (v1 + jumps to meet)

        this returns the value at the certain jump if they are equal therefore they meet and predicted jump is correct
        valueA == valueB ? "YES" : "NO"
         */

        if(v1 == v2){
            System.out.println("NO");
        } else {
            int predicted = (x2 - x1)/(v1 - v2);
            System.out.println(predicted);

            if(predicted < 1){
                System.out.println("NO");
            } else {
                int sumA = x1 + (v1 * predicted);
                int sumB = x2 + (v2 * predicted);
                System.out.println(sumA + " " + sumB);
                System.out.println(sumA == sumB ? "YES" : "NO");
            }
        }
    }
}
