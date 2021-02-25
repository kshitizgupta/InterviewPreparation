package com.miscProblems.array;

/**
 * Brute force approach is we start at each element and iterate further to get all the
 * contiguous sub com.arrays it can make, keep storing the sum for all of them so we can ultimately
 * get the max sum possible. But in this case the complexity will be O(n^2) as for first element
 * we will be forming n-1 contiguous sub com.arrays, for 2nd we will have n-2, so on and so forth
 * n+(n-1)+(n-2)+.....+1 = n^2
 *
 * But what we want to do is iterate just once and bring down the complexity to linear O(n).
 * So lets iterate through the array. For ex. {-2, 1, -3, 4, -1, 2, 1, -5, 4}
 * 1. -2, so the max sum here is -2
 * 2. 1, now the contiguous sum including 1 is -2+1=-1. But to maximise the sum we should exclude the
 * previous max sum -2 and just pick 1. So max sum now begins 1
 * 2. -3, max sum including -3 is 1 + -3 = -2. Now to maximise the sum we know we have got 1 previously.
 * So if the array ends here the max sum would be 1 which is excluding -3. But including -3 the max sum is
 * -2
 * 3. 4, max sum including 4 is -2+4 = 2. Now we have 2 options to find the current contiguous max sum.
 * Either including 4 with previous sum or just 4. If we take just 4 then current contiguous sum is 4.
 * Which means including it with previous current contiguous, the sum diminishes. Hence we should pick up
 * just 4. Now previous max sum was 1 and now we have 4, so 4 wins. so currentMaxSum=4 and maxSum = 4
 * 4.-1, including -1 currentMaxContiguous = 4-1 = 3. but maxSum remains 4 as 4 wins over 3
 * 5. 2, including 2 currentMaxContiguous = 3 + 2 = 5. since 5 wins over 4 so maxSum=5;
 *
 * As we see the trend, maxSum = max(currentMaxSum, maxSum)
 *
 * to calculate currentMaxContiguous we calculate the currentMaxSum including the current no. or just taking the
 * current number. currentMaxContiguous = max(currentMaxContiguous + arr[i], arr[i]).
 *
 * Below is the complete algo
 */
public class LargestSumContiguousArray {
    public static int execute(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int currentMaxContiguous = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currentMaxContiguous = Math.max(arr[i] + currentMaxContiguous, arr[i]);
            maxSum = Math.max(currentMaxContiguous, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("MaxSum = " + execute(arr));
        System.out.println("MaxSum = " + execute(new int[]{-2, -1, -3, -4, -1, -2, 0, -5, -4}));
        System.out.println("MaxSum = " + execute(new int[]{10, 2, 3, 4, 5, 6}));
        System.out.println("MaxSum = " + execute(null));
        System.out.println("MaxSum = " + execute(new int[]{}));
    }
}
