package main_pack;

import java.util.*;

public class Rotate2DArray {

    static int getValueAt(List<List<Integer>> dualArray, int AtIndex) {
        int rowIndex = AtIndex / dualArray.get(0).size();
        int colIndex = AtIndex % dualArray.get(0).size();
        return dualArray.get(rowIndex).get(colIndex);
    }

    static int[] getRowAndCol(int col_count, int AtIndex) {
        int rowIndex = AtIndex / col_count;
        int colIndex = AtIndex % col_count;
        return new int[]{rowIndex, colIndex};
    }

    static List<List<Integer>> mirrorDiagonal(List<List<Integer>> dualArray) {
        int[][] swapIndex = new int[][]{{3, 1}, {6, 2}, {7, 5}};

        for (int[] pairs : swapIndex) {
            int x = getValueAt(dualArray, pairs[0]);
            int temp = getValueAt(dualArray, pairs[1]);

            int[] row_col = getRowAndCol(dualArray.get(0).size(), pairs[1]);
            int[] row_col2 = getRowAndCol(dualArray.get(0).size(), pairs[0]);

            dualArray.get(row_col[0]).set(row_col[1], x);
            dualArray.get(row_col2[0]).set(row_col2[1], temp);
        }
        return dualArray;
    }

    public static List<List<Integer>> rotate(List<List<Integer>> dualArray){
        List<List<Integer>> returnArr = new ArrayList<>(dualArray);
        //System.out.println("Passed: " + returnArr);
        int swapCount;
        int replacingValue;

        int[] edgeRotation = new int[]{0, 2, 8, 6, 0};
        int[] wedgeRotation = new int[]{3, 1, 5, 7, 3};

        swapCount = 0;
        replacingValue = getValueAt(returnArr, edgeRotation[swapCount]);
        //edge rotation
        while (swapCount < edgeRotation.length - 1) {
            int[] row_col = getRowAndCol(returnArr.get(0).size(), edgeRotation[swapCount + 1]);
            int temp = returnArr.get(row_col[0]).get(row_col[1]);
            returnArr.get(row_col[0]).set(row_col[1], replacingValue);
            replacingValue = temp;
            swapCount++;
        }
        swapCount = 0;
        replacingValue = getValueAt(returnArr, wedgeRotation[swapCount]);
        //wedge rotation
        while (swapCount < wedgeRotation.length - 1) {
            int[] row_col = getRowAndCol(returnArr.get(0).size(), wedgeRotation[swapCount + 1]);
            int temp = returnArr.get(row_col[0]).get(row_col[1]);
            returnArr.get(row_col[0]).set(row_col[1], replacingValue);
            replacingValue = temp;
            swapCount++;
        }
        //System.out.println("End: " + returnArr);
        return returnArr;
    }


    public static Map<Integer, List<List<Integer>>> rotate2DArray(List<List<Integer>> dualArrayIN) {
        LinkedHashMap<Integer, List<List<Integer>>> allMSquares = new LinkedHashMap<>();

        List<List<List<Integer>>> mSquares = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            List<List<Integer>> returnedArr = rotate(dualArrayIN);
            mSquares.add(returnedArr);
            dualArrayIN = new ArrayList<>(returnedArr);
        }
        for (List<List<Integer>> mSquare : mSquares) {
            System.out.println("Res: " + mSquare);
        }
        return allMSquares;
    }

    public static void main(String[] args) {
        List<List<Integer>> dualArray = new ArrayList<>();
        dualArray.add(new ArrayList<>() {{
            add(8);
            add(1);
            add(6);
        }});
        dualArray.add(new ArrayList<>() {{
            add(3);
            add(5);
            add(7);
        }});
        dualArray.add(new ArrayList<>() {{
            add(4);
            add(9);
            add(2);
        }});

        Map<Integer, List<List<Integer>>> allMSquares1 = rotate2DArray(dualArray);
        /*for (Map.Entry<Integer, List<List<Integer>>> items : allMSquares1.entrySet()) {
            System.out.println(items.getValue());
        }*/
        /*Map<Integer, List<List<Integer>>> allMSquares2 = rotate2DArray(mirrorDiagonal(dualArray));
        allMSquares1.putAll(allMSquares2);
        for (Map.Entry<Integer, List<List<Integer>>> items : allMSquares1.entrySet()) {
            System.out.println(items.getValue());
        }*/

        Collections.sort(dualArray, Collections.reverseOrder());
    }
}
