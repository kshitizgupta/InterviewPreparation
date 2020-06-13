package miscProblems;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You
 * are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in
 * ascending order.
 *
 * For example, given the array
 * [7, 1, 3, 2, 4, 5, 6] min swaps = 5
 * [1 3 5 2 4 6 7] min swaps = 3
 *
 * To achieve minimum swaps we should look to acheive one thing, that t=in each swap we are able to make at least
 * one of the swapped numbers to reach its actual position
 */
public class CountMinSwapsToSort1ToNUnOrderedArray {
    static int minimumSwaps(int[] arr) {
        int count = 0;
        Map<Integer, Integer> numToPos = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int expectedPos = arr[i] - 1;
            if (i != expectedPos) {
                numToPos.put(arr[i], i);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int expectedPos = arr[i] - 1;
            if (i != expectedPos) {
                numToPos.put(arr[i], numToPos.get(i + 1));
                swap(arr, i, numToPos.get(i + 1));
                count++;
            }
        }
        return count;
    }

    static void swap(int[] arr, int i, int j) {
        int buff = arr[i];
        arr[i] = arr[j];
        arr[j] = buff;
    }

    public static void main(String[] args) {
        test(new int[]{7, 1, 3, 2, 4, 5, 6});
        test(new int[]{1, 3, 5, 2, 4, 6, 7});
        test(new int[]{4, 3, 1, 2});
    }

    public static void test(int[] arr) {
        System.out.println("Min swaps = " + minimumSwaps(arr));
    }
}
