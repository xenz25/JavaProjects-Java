package main_pack;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ClimbingLeaderBoard {
    public static void main(String[] args){
        //test case
        List<Integer> current_leader_board = new ArrayList<>(){{
            add(100);
            add(100);
            add(50);
            add(40);
            add(40);
            add(20);
            add(10);
        }};

        List<Integer> player_score = new ArrayList<>(){{
            add(5);
            add(25);
            add(50);
            add(120);
        }};

        /*List<Integer> current_leader_board = new ArrayList<>(){{
            add(1);
        }};

        List<Integer> player_score = new ArrayList<>(){{
            add(1);
            add(1);
        }};*/

        //remove duplicates and sort in reverse order
        //List<Integer> score_map_reversed = new HashSet<>(current_leader_board).stream().sorted().collect(Collectors.toList());
        //System.out.println(score_map_reversed.toString());



       /* List<Integer> rank = new ArrayList<>();
        LinkedHashSet<Integer> scores = new LinkedHashSet<>(current_leader_board);
        scores.addAll(player_score);

        System.out.print(scores.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).toString());

        for(Integer x : player_score){
            System.out.println(scores.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).indexOf(x));
            //rank.add(scores.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).indexOf(x)+1);
        }
        //System.out.println(rank);*/

        //time limit exceed
        /*List<Integer> leader_board = new ArrayList<>(new LinkedHashSet<>(current_leader_board));
        List<Integer> rank = new ArrayList<>();
        for (Integer score : player_score) {
            boolean removed = !leader_board.contains(score);
            leader_board.add(score);
            leader_board.sort(Collections.reverseOrder());
            System.out.println("-> " + leader_board);
            rank.add(leader_board.indexOf(score)+1);
            if(removed) leader_board.remove(score);
        }
        System.out.println(rank);*/

        /*LinkedHashSet<Integer> score_map = new LinkedHashSet<>(current_leader_board);
        Stream<Integer> stream = score_map.stream().sorted();
        stream.forEach(System.out::println);*/

        //algo 3 using array distance - didn't work on some given
        /*LinkedHashSet<Integer> scoreBoard = new LinkedHashSet<>(current_leader_board);
        List<Integer> leader_board = new ArrayList<>(scoreBoard);
        leader_board.addAll(player_score);
        leader_board.sort(Collections.reverseOrder());

        List<Integer> rank = new ArrayList<>();

        for(int i = 0; i < player_score.size(); i++){
            rank.add((leader_board.indexOf(player_score.get(i)) - (player_score.size() - (i+1)))+1);
        }

        System.out.println(rank);*/

        /*List<Integer> score_map_reversed = new HashSet<>(current_leader_board).stream().sorted().collect(Collectors.toList());
        List<Integer> rank = new ArrayList<>();

        for(Integer score : player_score){
            int current = score_map_reversed.size()+1;
            for(Integer leader : score_map_reversed){
                if(score.equals(leader)) {
                    rank.add(current-1); break;
                } else if(score < leader){
                    rank.add(current); break;
                } else current--;
                if(current == 2){
                    rank.add(1);
                    break;
                }
            }
        }*/

        List<Integer> resultList  = new ArrayList<>();
        List<Integer> rankScoreList = new HashSet<>(current_leader_board).stream()
                .sorted(Collections.reverseOrder()).collect(Collectors.toList());

        int x = rankScoreList.size()-1, y = 0;

        while(y < player_score.size()) {
            if(x == -1){
                resultList.add(1);
                y++;
            } else if (player_score.get(y) >= rankScoreList.get(x)) {
                x--;
            } else {
                resultList .add(x+2);
                y++;
            }
        }

        System.out.println(resultList);
    }
}
