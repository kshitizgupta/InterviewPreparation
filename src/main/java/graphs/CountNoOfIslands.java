package graphs;

import java.util.Stack;

public class CountNoOfIslands {
    class Coordinates {
        int i;
        int j;

        public Coordinates(final int i, final int j) {
            this.i = i;
            this.j = j;
        }
    }

    public int countNoOfIslands(int[][] mat, int size) {
        int[][] visited = new int[size][size];
        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (mat[i][j] != 0 && visited[i][j] != 1) {
                    traverse(mat, i, j, visited, size);
                    count++;
                }
            }
        }

        return count;
    }

    private void traverse(final int[][] mat, final int i, final int j, int[][] visited, int size) {
        Stack<Coordinates> stk = new Stack<Coordinates>();
        stk.push(new Coordinates(i, j));
        traverseRecur(mat, size, stk, visited);
    }

    private boolean isValidCoordinates(int size, int i, int j) {
        return i >= 0 && i < size && j >= 0 && j < size;
    }

    private void traverseRecur(
        final int[][] mat,
        int size,
        Stack<Coordinates> stk,
        int[][] visited
    ) {
        final Coordinates top = stk.pop();
        int i = top.i;
        int j = top.j;

        if (mat[i][j] == 0 || visited[i][j] == 1) {
            return;
        }
        visited[i][j] = 1;

        //Right
        if (isValidCoordinates(size, i, j + 1)) {
            stk.push(new Coordinates(i, j + 1));
            traverseRecur(mat, size, stk, visited);
        }

        //Right below
        if (isValidCoordinates(size, i + 1, j + 1)) {
            stk.push(new Coordinates(i + 1, j + 1));
            traverseRecur(mat, size, stk, visited);
        }

        //Below
        if (isValidCoordinates(size, i + 1, j)) {
            stk.push(new Coordinates(i + 1, j));
            traverseRecur(mat, size, stk, visited);
        }

        //left Below
        if (isValidCoordinates(size, i + 1, j - 1)) {
            stk.push(new Coordinates(i + 1, j - 1));
            traverseRecur(mat, size, stk, visited);
        }

        //left
        if (isValidCoordinates(size, i, j - 1)) {
            stk.push(new Coordinates(i, j - 1));
            traverseRecur(mat, size, stk, visited);
        }

        //left up
        if (isValidCoordinates(size, i - 1, j - 1)) {
            stk.push(new Coordinates(i - 1, j - 1));
            traverseRecur(mat, size, stk, visited);
        }

        //up
        if (isValidCoordinates(size, i - 1, j)) {
            stk.push(new Coordinates(i - 1, j));
            traverseRecur(mat, size, stk, visited);
        }

        //right up
        if (isValidCoordinates(size, i - 1, j + 1)) {
            stk.push(new Coordinates(i - 1, j + 1));
            traverseRecur(mat, size, stk, visited);
        }

    }

    public static void main(String[] args) {
        int[][] mat = {
            {1, 1, 0, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 0, 0, 0},
            {1, 0, 1, 0, 1}
        };

        System.out.println("Count = " + new CountNoOfIslands().countNoOfIslands(mat, 5));
    }
}
