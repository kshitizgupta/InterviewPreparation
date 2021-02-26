package com.slidingWindow;

public class MaximumAverageSubarraySizeK {
    public static double solution(int[] arr, int k) {
        int i = 0, j = 0;
        double maxAvg = Integer.MIN_VALUE;
        double movingAvg = 0;
        double sum = 0;
        for (; j < k; j++) {
            sum += arr[j];
        }
        movingAvg = Double.valueOf(sum) / k;
        j--;

        while (j < arr.length) {
            maxAvg = Math.max(movingAvg, maxAvg);

            i++;
            j++;
            if (j < arr.length) {
                movingAvg = movingAvg - Double.valueOf(arr[i - 1]) / k + Double.valueOf(arr[j]) / k;
            }
        }

        return maxAvg;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 12, -5, -6, 50, 3}, 4));
    }
}
