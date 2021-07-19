package main_pack;

public class FactorialByRecursion {
    //only works for small numbers
    static int mul(int num){
        if(num <= 1) return 1;
        return num * mul(num - 1);
    }

    public static void main(String[] args){
        int number = 5;
        System.out.println(mul(number));
    }
}
