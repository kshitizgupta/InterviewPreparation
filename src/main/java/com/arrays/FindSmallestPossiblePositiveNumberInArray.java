package com.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an unsorted array with both positive and negative elements. You have to find the smallest positive
 * number missing from the array in O(n) time using constant extra space. You can modify the original array.
 *
 * Examples
 *
 *  Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 *  Output: 1
 *
 *  Input:  { 2, 3, -7, 6, 8, 1, -10, 15 }
 *  Output: 4
 *
 *  Input: {1, 1, 0, -1, -2}
 *  Output: 2
 */
public class FindSmallestPossiblePositiveNumberInArray {
    public static int getAnswer(int[] arr) {
        int indexLastPositive = partitionIntoPositiveNegative(arr);

        if (indexLastPositive < 0) {
            return findMax(arr) + 1;
        }

        for (int i = 0; i <= indexLastPositive; i++) {
            int calAtIndex = Math.abs(arr[i]);

            if (calAtIndex <= indexLastPositive && calAtIndex != 0 && arr[calAtIndex - 1] > 0) {
                arr[calAtIndex - 1] = -arr[calAtIndex - 1];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) return i + 1;
        }

        return -1;
    }

    private static int findMax(final int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int value : arr) {
            max = Math.max(max, value);
        }
        return max;
    }

    public static int partitionIntoPositiveNegative(int[] arr) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            while (arr[start] > 0 && start < arr.length) {
                start++;
            }
            while (arr[end] < 0 && end >= 0) {
                end--;
            }

            if (start < end) {
                int val = arr[start];
                arr[start] = arr[end];
                arr[end] = val;
            }
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println("Answers :");

        List<Integer> inputs = new ArrayList<>();

        System.out.println(FindSmallestPossiblePositiveNumberInArray.getAnswer(new int[]{
            2,
            3,
            -7,
            -6,
            8,
            15,
            -10,
            -1
        }));
        System.out.println(FindSmallestPossiblePositiveNumberInArray.getAnswer(new int[]{2, 3, -7, 6, 8, 1, -10, 15}));
        System.out.println(FindSmallestPossiblePositiveNumberInArray.getAnswer(new int[]{1, 1, 0, -1, -2}));
    }
}
