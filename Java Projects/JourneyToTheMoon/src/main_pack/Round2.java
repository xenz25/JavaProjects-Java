package main_pack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Round2 {
    static int[] genRepresentation(List<List<Integer>> astronaut) {
        List<Integer> merged = new ArrayList<>();
        //-------------------------------------------
        //1. Merge List
        for (List<Integer> integers : astronaut) {
            merged.addAll(integers);
        }

        //2. Find Max
        int max = Collections.max(merged);
        int[] rep = new int[max + 1];
        Arrays.fill(rep, -1);
        //System.err.println(max);

        //3. Create Representation
        for (List<Integer> list : astronaut) {
            if (rep[list.get(0)] == -1) {
                rep[list.get(0)] = list.get(0); //parent
            }
            rep[list.get(1)] = rep[list.get(0)]; //child
        }
        //5. Output Representation
        //System.out.println(merged);
        return rep;
    }

    public static void main(String[] args) {
        /*List<List<Integer>> astronaut = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(0);
                add(1);
            }});
            add(new ArrayList<>() {{
                add(2);
                add(3);
            }});
            add(new ArrayList<>() {{
                add(0);
                add(4);
            }});
        }};*/

        /*List<List<Integer>> astronaut = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(1);
                add(2);
            }});
            add(new ArrayList<>() {{
                add(2);
                add(3);
            }});
        }};*/

        List<List<Integer>> astronaut = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(2);
                add(1);
            }});
            add(new ArrayList<>() {{
                add(0);
                add(1);
            }});
        }};

        long summation = 1;
        int[] arrGen = genRepresentation(astronaut);
        System.out.println(Arrays.toString(arrGen));

        int excess = 0;
        int prevScanned = -1;
        for(int i = 0; i < arrGen.length; i++){
            long pair = 0;
            int finalI = i;
            if(arrGen[i] == -1) pair++;
            else if(prevScanned != finalI) {
                pair+= IntStream.of(arrGen)
                        .filter(index -> index == finalI).parallel().boxed().count();
            }
            prevScanned = finalI;
            if(pair != 0)
                summation*=pair;
            if(pair == 1) excess+=pair;
        }
        System.out.println(summation+excess);
    }
}