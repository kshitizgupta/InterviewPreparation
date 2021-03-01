package com.slidingWindow;

public class LargestSubArrayOfSumKPositiveIntegers {
    public static int solution(int[] arr, int k) {
        int i = 0, j = 0;
        int currSum = arr[0];
        int maxSize = 0;

        while (j < arr.length) {
            if (currSum == k) {
                maxSize = Math.max(maxSize, j - i + 1);
                j++;
                if (j < arr.length)
                    currSum += arr[j];
            } else if (currSum < k) {
                j++;
                if (j < arr.length) {
                    currSum += arr[j];
                }
            } else {
                i++;
                if (i < arr.length)
                    currSum -= arr[i - 1];
            }
        }

        return maxSize;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{10, 5, 2, 7, 1, 9}, 15));
    }
}
