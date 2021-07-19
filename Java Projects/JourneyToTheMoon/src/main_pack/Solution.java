package main_pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    static int[] generateBaseArray(int size){
        int[] returnArr = new int[size];
        for(int i = 0; i < size; i++)
            returnArr[i] = i;
        return returnArr;
    }

    static int findRoot(int[] fromArr, int ofElement){
        while(ofElement != fromArr[ofElement])
            ofElement = fromArr[ofElement];
        return ofElement;
    }

    static void union(int[] inArr, int p, int q){
        //quick union
        int pRoot = findRoot(inArr, p);
        int qRoot = findRoot(inArr, q);

        inArr[pRoot] = qRoot; //change root of p to q
    }

    static List<Integer> getDisjointSet(int[] inArr, int fromElement){
        List<Integer> sets = new ArrayList<>();
        sets.add(fromElement);
        while(fromElement != inArr[fromElement]){
            int temp = fromElement;
            fromElement = inArr[fromElement];
            sets.add(fromElement);
            inArr[temp] = -1;
        }
        inArr[fromElement] = -1;
        return sets;
    }

    public static void main(String[] args){
        /*List<List<Integer>> astronauts = new ArrayList<>(){{
           add(new ArrayList<>(){{
               add(1);
               add(2);
           }});
           add(new ArrayList<>(){{
               add(2);
               add(3);
           }});
        }};*/

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

        List<List<Integer>> astronauts = new ArrayList<>(){{
           add(new ArrayList<>(){{
               add(1);
               add(2);
           }});
           add(new ArrayList<>(){{
               add(3);
               add(4);
           }});
           add(new ArrayList<>(){{
               add(0);
               add(4);
           }});
        }};


        //1. Create Base Array
        int[] baseArray = generateBaseArray(100000);
        System.out.println(Arrays.toString(baseArray));

        //2. Create Connections
        for(List<Integer> list : astronauts){
            System.out.println(list);
            union(baseArray, list.get(0), list.get(1));
            System.out.println(Arrays.toString(baseArray));
        }


        //System.out.println(Arrays.toString(baseArray));

        List<List<Integer>> disjointSet = new ArrayList<>();

        //3. Collect Disjoint Sets
        for(int i = 0; i < baseArray.length; i++){
            if(baseArray[i] != -1){
                disjointSet.add(getDisjointSet(baseArray, i));
            }
        }

        System.out.println(Arrays.toString(baseArray));
        System.out.println(disjointSet);

        //4. CalculatePossible Pairs
        long totalPairs = 0;
        long sum = 0;
        for(List<Integer> list : disjointSet){
            totalPairs += sum* list.size();
            sum+= list.size();
        }
        System.out.println("Total Pairs: " + totalPairs);
    }
}
