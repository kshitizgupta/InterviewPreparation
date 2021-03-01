package com.arrays;

/**
 * Problem:
 *
 * Given 2 arrays:
 *
 * [1 7 8 9 11 13 15 18 20 32]
 * [5 8 10 12 13 14 20 25 30 45]
 *
 * Aim is to find sum of all slices with greater value. These slices get formed if we find common
 * elements in both the array
 *
 * In above example following slices are formed
 *
 * 1 7  #8  9 11 #13 15 18 #20 32
 * 5    #8 10 12 #13 14    #20 30 45
 *
 * so picking up those slices which are greater like 1 + 7 > 5 and 9+11<10+12
 *
 * so (1+7) + (10+20) + (15+18) + (30+45)
 */
public class MaxUnionSum {
    static int getMaxUnionSum(int[] arr1, int[] arr2) {
        int start1 = 0, start2 = 0;
        int maxSum = 0;
        int currSliceSum1 = 0;
        int currSliceSum2 = 0;
        while (start1 < arr1.length && start2 < arr2.length) {
            if (arr1[start1] == arr2[start2]) {
                maxSum += Math.max(currSliceSum1, currSliceSum2);
                currSliceSum1 = 0;
                currSliceSum2 = 0;
                start1++;
                start2++;
            } else {
                if (arr1[start1] < arr2[start2]) {
                    currSliceSum1 += arr1[start1];
                    start1++;
                } else if (arr2[start2] < arr1[start1]) {
                    currSliceSum2 += arr2[start2];
                    start2++;
                }
            }

        }

        while (start1 < arr1.length) {
            currSliceSum1 += arr1[start1];
            start1++;
        }

        while (start2 < arr2.length) {
            currSliceSum2 += arr2[start2];
            start2++;
        }

        maxSum += Math.max(currSliceSum1, currSliceSum2);

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(getMaxUnionSum(
            new int[]{1, 7, 8, 9, 11, 13, 15, 18, 20, 32},
            new int[]{5, 8, 10, 12, 13, 14, 20, 25, 30, 45}
        ));
    }

}
