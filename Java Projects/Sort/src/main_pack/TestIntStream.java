package main_pack;

import java.util.ArrayList;
import java.util.List;

public class TestIntStream {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(){{
           add(-1);
           add(-3);
           add(4);
           add(2);
        }};
        int k = 3;
        long students = a.stream().filter(i -> i <= 0).count();
        System.out.println((students < k) ? "YES" : "NO");
    }
}
