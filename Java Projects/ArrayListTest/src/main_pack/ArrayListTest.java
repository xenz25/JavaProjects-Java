package main_pack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(6);
		list1.add(5);
		list1.add(4);
		
		Object itemObject = 1;
		
		list1.add((int) itemObject);
		System.out.println(list1.toString());

	}

}
