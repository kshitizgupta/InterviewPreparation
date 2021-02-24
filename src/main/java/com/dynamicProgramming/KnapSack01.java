package com.dynamicProgramming;

import java.util.HashMap;

public class KnapSack01 {
    private static HashMap<String, Integer> memoizationMap = new HashMap();
    private static int[][] matrix = new int[100][100];

    public static int knapSackRecur(int[] wt, int[] val, int w, int index) {
        String s = w + "," + index;
        if (index >= wt.length || w <= 0) {
            return 0;
        }

        if (memoizationMap.containsKey(s)) {
            return memoizationMap.get(s);
        }

        if (wt[index] <= w) {
            memoizationMap.put(
                s,
                Math.max(
                    knapSackRecur(wt, val, w - wt[index], index + 1) + val[index],
                    knapSackRecur(wt, val, w, index + 1)
                )
            );
        } else
            memoizationMap.put(s, knapSackRecur(wt, val, w, index + 1));

        return memoizationMap.get(s);
    }

    public static int knapSackTabulation(int[] wt, int[] val, int w) {
        for (int i = 1; i <= wt.length; i++) {
            for (int j = 1; j <= w; j++) {

                if (wt[i - 1] <= j) {
                    matrix[i][j] = Math.max(
                        val[i - 1] + matrix[i - 1][j - wt[i - 1]],
                        matrix[i - 1][w]
                    );
                } else {
                    matrix[i][j] = matrix[i - 1][w];
                }
            }
        }

        return matrix[wt.length][w];
    }

    public static void main(String[] args) {
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        System.out.println("\n" + knapSackRecur(wt, val, 50, 0));
        System.out.println("\n" + knapSackTabulation(wt, val, 50));

    }
}
