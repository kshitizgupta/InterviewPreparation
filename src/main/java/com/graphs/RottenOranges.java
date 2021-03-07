package com.graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 *
 * Example 1:
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * Example 2:
 *
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
 * Example 3:
 *
 * Input: grid = [[0,2]]
 * Output: 0
 * Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 */
public class RottenOranges {
    static class Orange {
        final int i;
        final int j;

        public Orange(final int i, final int j) {
            this.i = i;
            this.j = j;
        }
    }

    public static int solution(int[][] grid) {
        Queue<Orange> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Orange(i, j));
                }
            }
        }
        q.offer(null);
        int timeFrame = 0;
        while (!q.isEmpty()) {
            Orange polled = q.poll();

            if (polled == null) {
                timeFrame++;
                if (!q.isEmpty()) {
                    q.offer(null);
                }
                continue;
            }
            if (isValid(polled.i - 1, polled.j, grid) && grid[polled.i - 1][polled.j] == 1) {
                grid[polled.i - 1][polled.j] = 2;
                q.offer(new Orange(polled.i - 1, polled.j));
            }

            if (isValid(polled.i, polled.j - 1, grid) && grid[polled.i][polled.j - 1] == 1) {
                grid[polled.i][polled.j - 1] = 2;
                q.offer(new Orange(polled.i, polled.j - 1));
            }

            if (isValid(polled.i + 1, polled.j, grid) && grid[polled.i + 1][polled.j] == 1) {
                grid[polled.i + 1][polled.j] = 2;
                q.offer(new Orange(polled.i + 1, polled.j));
            }

            if (isValid(polled.i, polled.j + 1, grid) && grid[polled.i][polled.j + 1] == 1) {
                grid[polled.i][polled.j + 1] = 2;
                q.offer(new Orange(polled.i, polled.j + 1));
            }

        }

        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }

        return timeFrame - 1;
    }

    public static boolean isValid(int i, int j, int[][] grid) {
        return i < grid.length && i >= 0 && j >= 0 && j < grid[0].length;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        System.out.println(solution(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        System.out.println(solution(new int[][]{{0, 2}}));
    }
}
