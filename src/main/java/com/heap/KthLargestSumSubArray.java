package com.heap;

// Java program to find the k-th largest sum of subarray

import java.util.*;

class KthLargestSumSubArray {
    // function to calculate kth largest
    // element in contiguous subarray sum
    static int kthLargestSum(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (pq.size() < k) {
                    pq.offer(sum);
                } else if (pq.peek() < sum) {
                    pq.poll();
                    pq.offer(sum);
                }
            }
        }
        return pq.peek();
    }

    // Driver Code
    public static void main(String[] args) {
        int a[] = new int[]{10, -10, 20, -40};
        int n = a.length;
        int k = 3;

        // calls the function to find out the
        // k-th largest sum
        System.out.println(kthLargestSum(a, k));
    }
}

