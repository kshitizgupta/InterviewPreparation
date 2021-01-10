package com.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * There are n nails hammered into same block of wood. Each nail sticks out of wood at different lengths
 * You can choose at most k nails and hammer them down to any length between their original length and 0.
 * Nails cant be pulled up. Goal is to have as many nails at same length as possible
 */
public class NailsHammeredDifferentLength {
    public static void main(String[] args) {
        System.out.println(solutionOneIteration(new int[]{1, 1, 3, 3, 4, 4, 4, 5, 5}, 2));
        System.out.println(solutionTwoIterations(new int[]{1, 1, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6, 6, 6, 6}, 2));
    }

    public static int solutionOneIteration(int[] arr, int k) {
        int max = 0;
        int currFreq = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1 && arr[i] == arr[i + 1]) {
                currFreq++;
            } else {
                int currMax = currFreq + Math.min(k, arr.length - i - 1);
                currFreq = 1;
                max = Math.max(max, currMax);
            }
        }

        return max;
    }

    public static int solutionTwoIterations(int[] arr, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : arr) {
            if (!frequencies.containsKey(num)) {
                frequencies.put(num, 1);
            } else {
                frequencies.put(num, frequencies.get(num) + 1);
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; ) {
            int currMax = frequencies.get(arr[i]) + Math.min(k, arr.length - (i + frequencies.get(arr[i])));
            max = Math.max(currMax, max);
            i += frequencies.get(arr[i]);
        }

        return max;
    }
}
