package main_pack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickUnion {

    static int[] generateCompleteSet(int size){
        //create a initial list with each element is their parent
        int[] arr = new int[size];
        for(int i = 0; i < arr.length; i++){
            arr[i] = i;
        }
        return arr;
    }

    static int findRoot(int[] from_arr, int ofElement){
        while(ofElement != from_arr[ofElement]){
            ofElement = from_arr[ofElement];
        }
        return ofElement;
    }

    static int[] findRootAndCount(int[] from_arr, int from_element){
        //find the root of element and then each searching count the traversed leaf's up to root and change all
        //direction to root
        int root = findRoot(from_arr, from_element);
        int involve_nodes = 1;
        while(from_element != from_arr[from_element]){
            from_element = from_arr[from_element];
            from_arr[from_element] = root; //direct element to its root
            involve_nodes++;
        }
        return new int[]{root, involve_nodes};
    }

    static void union(int[] from_arr, int p, int q){
        int pRoot = findRoot(from_arr, p);
        int qRoot = findRoot(from_arr, q);

        from_arr[pRoot] = qRoot;
    }

    public static void main(String[] args){
        int size = 4;
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

        List<List<Integer>> astronaut = new ArrayList<>() {{
            add(new ArrayList<>() {{
                add(0);
                add(2);
            }});
        }};

        int[] arr = generateCompleteSet(size);
        System.out.println(Arrays.toString(arr));
        for(List<Integer> list : astronaut){
            union(arr, list.get(0), list.get(1));
        }
        System.out.println(Arrays.toString(arr));

        int total = 1;
        int prevRoot = -1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != i && arr[i] != prevRoot){
                //a child
                int[] involveChild = findRootAndCount(arr, i);
                prevRoot = involveChild[0];
                total*=involveChild[1];
                System.out.println("arr: " + Arrays.toString(arr));
            }
        }

        System.out.println("Total: " + total);
    }
}
