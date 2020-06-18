package com.arrays;

public class LargestContiguousSumGreaterThanK {
    public static SubArray execute(int[] arr, int k) {
        int localMax = arr[0];
        int globalMax = arr[0];
        SubArray result = new SubArray();
        result.startIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            localMax = Math.max(localMax + arr[i], arr[i]);
            globalMax = Math.max(globalMax, localMax);
            if (localMax > k) {
                result.endIndex = i;
            }
        }
        result.sum = globalMax;
        int counter = globalMax;
        for (int i = result.endIndex; i >= 0; i--) {
            counter -= arr[i];
            if (counter <= 0) {
                result.startIndex = i;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(execute(new int[]{-2, 1, 6, -3}, 5));
        System.out.println(execute(new int[]{2, -3, 3, 2, 0, -1}, 3));
    }
}
