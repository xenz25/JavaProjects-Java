package main_pack;

import java.util.ArrayList;
import java.util.List;

public class CompareTheTriplet {

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<>() {{
			add(17);
			add(28);
			add(30);
		}};
		List<Integer> b = new ArrayList<>() {{
			add(99);
			add(16);
			add(8);
		}};
		
		List<Integer> scores = new ArrayList<Integer>(){{add(0); add(0);}};
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) > b.get(i)) scores.set(0, (scores.get(0) + 1));
            else if (a.get(i) < b.get(i)) scores.set(1, (scores.get(1) + 1));
        }
		
		System.out.println(scores);

	}

}
