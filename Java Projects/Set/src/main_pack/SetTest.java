package main_pack;
import java.util.*;


public class SetTest {
public static void main(String[] args) {
		Set<List<Integer>> hash_set = new HashSet<>();
		
		List<Integer> a1 = new ArrayList<Integer>(){{
			add(1);
			add(2);
		}};
		
		List<Integer> a2 = new ArrayList<Integer>(){{
			add(1);
			add(2);
		}};
		
		List<Integer> a3 = new ArrayList<Integer>(){{
			add(2);
			add(2);
		}};
		hash_set.add(a1);
		hash_set.add(a2);
		hash_set.add(a3);
		
		List<Integer> a4 = new ArrayList<Integer>(){{
			add(5);
			add(6);
		}};
		
		System.out.println(hash_set.contains(a4));
		
		System.out.println(hash_set.toString());
		
		char c = 97;
		System.out.println(c);
	}

}
