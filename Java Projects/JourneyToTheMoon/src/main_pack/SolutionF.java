package main_pack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SolutionF {
    static int findParent(int ofChild, int[] inArr){
        while(ofChild != inArr[ofChild])
            ofChild = inArr[ofChild];
        return ofChild;
    }

    static void join(List<Integer> list, int[] inArr, int[] sizeOfChild){
        int parentOfP = findParent(list.get(0), inArr);
        int parentOfQ = findParent(list.get(1), inArr);
        if(parentOfP == parentOfQ) return;
        if(sizeOfChild[parentOfP] < sizeOfChild[parentOfQ]){
            inArr[parentOfP] = parentOfQ;
            sizeOfChild[parentOfQ]+=sizeOfChild[parentOfP];
        } else {
            inArr[parentOfQ] = parentOfP;
            sizeOfChild[parentOfP]+=sizeOfChild[parentOfQ];
        }
    }

    public static void main (String[] args){
        List<List<Integer>> astronauts = new ArrayList<>(){{
            add(new ArrayList<>(){{
                add(1);
                add(2);
            }});
            add(new ArrayList<>(){{
                add(2);
                add(3);
            }});
        }};

        /*List<List<Integer>> astronauts = new ArrayList<>(){{
            add(new ArrayList<>(){{
                add(0);
                add(1);
            }});
            add(new ArrayList<>(){{
                add(2);
                add(3);
            }});
            add(new ArrayList<>(){{
                add(0);
                add(4);
            }});
        }};*/

        int n = 4;
        int[] graph = IntStream.range(0, n).toArray();
        int[] sizeOfChild = new int[n];
        Arrays.fill(sizeOfChild, 1);

        System.out.println("Before modification: " + Arrays.toString(graph));

        for(List<Integer> list : astronauts) join(list, graph, sizeOfChild);

        System.out.println("After modification: " + Arrays.toString(graph));
        System.out.println("Element sizes: " + Arrays.toString(sizeOfChild));

        int possiblePairs = 0;
        int sum = 0;
        for(int i = 0; i < graph.length; i++){
            if(graph[i] == i){
                //if parent get size
                int size = sizeOfChild[i];
                possiblePairs += sum*size;
                sum+=size;
            }
        }
        System.out.println("Possible Pairs: " + possiblePairs);
    }
}
