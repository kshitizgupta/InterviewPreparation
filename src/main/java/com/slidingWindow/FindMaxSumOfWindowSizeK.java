package com.slidingWindow;

public class FindMaxSumOfWindowSizeK {
    public static int solution(int[] arr, int k) {
        int i = 0, j = -1;
        int maxSum = 0;
        int currSum = 0;

        for (j = 0; j < k; j++) {
            currSum += arr[j];
        }
        j--;
        while (j < arr.length) {
            maxSum = Math.max(maxSum, currSum);
            i++;
            j++;
            if (j < arr.length)
                currSum = currSum - arr[i - 1] + arr[j];
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 3, 5, 2, 9, 7, 1}, 3));
    }
}
