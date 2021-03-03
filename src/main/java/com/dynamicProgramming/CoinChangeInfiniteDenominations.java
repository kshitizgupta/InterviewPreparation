package com.dynamicProgramming;

/**
 * You are given coins of different denominations and a total amount of money. Write a function to compute the number of combinations that make up that amount. You may assume that you have infinite number of each kind
 * of coin.
 *
 *
 *
 * Example 1:
 *
 * Input: amount = 5, coins = [1, 2, 5]
 * Output: 4
 * Explanation: there are four ways to make up the amount:
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * Example 2:
 *
 * Input: amount = 3, coins = [2]
 * Output: 0
 * Explanation: the amount of 3 cannot be made up just with coins of 2.
 * Example 3:
 *
 * Input: amount = 10, coins = [10]
 * Output: 1
 */
public class CoinChangeInfiniteDenominations {
    public static int solution(int amount, int[] coins) {
        int N = coins.length + 1;
        int M = amount + 1;
        int[][] combinations = new int[N][M];

        for (int i = 1; i < M; i++) {
            combinations[0][i] = 0;
        }

        for (int i = 0; i < N; i++) {
            combinations[i][0] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (j >= coins[i - 1]) {
                    combinations[i][j] = combinations[i][j - coins[i - 1]] + combinations[i - 1][j];
                } else {
                    combinations[i][j] = combinations[i - 1][j];
                }
            }
        }

        return combinations[coins.length][amount];
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1, 2, 5}));
    }

}
