package arrays;

import java.util.Arrays;
import org.w3c.dom.ls.LSOutput;

public class RemoveMinNoOfElementsForMaxMinusMinLessThanEqualK {
    int[][] removalsCache;

    public RemoveMinNoOfElementsForMaxMinusMinLessThanEqualK(int i) {
        removalsCache = new int[i][i];
        for (int[] arr : removalsCache) {
            Arrays.fill(arr, -1);
        }
    }

    private int countRemovals(int[] arr, int i, int j, int k) {
        if (j <= i) return 0;

//        System.out.println(i + "," + j);
        if (removalsCache[i][j] != -1) {
            return removalsCache[i][j];
        }

        if (arr[j] - arr[i] <= k) {
            removalsCache[i][j] = j - i + 1;
            return removalsCache[i][j];
        }

        int finalVal = Math.max(countRemovals(arr, i, j - 1, k), countRemovals(arr, i + 1, j, k));

        removalsCache[i][j] = finalVal;

        return removalsCache[i][j];
    }

    public int countRemovals(int[] arr, int k) {
        Arrays.sort(arr);
        return arr.length - countRemovals(arr, 0, arr.length - 1, k);
    }

    public static void main(String[] args) {
        final int[] arr = {
            1, 3, 4, 9, 10, 11, 12, 17, 20
        };
        RemoveMinNoOfElementsForMaxMinusMinLessThanEqualK algo =
            new RemoveMinNoOfElementsForMaxMinusMinLessThanEqualK(arr.length);

//        System.out.printf("Removals = " + algo.countRemovals(arr, 4));

        System.out.println("removals = " + algo.countRemovals(new int[]{1, 5, 6, 2, 8}, 2));
    }

}
