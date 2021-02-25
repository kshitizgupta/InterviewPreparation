package com.stack;

import java.util.Stack;

public class HistogramMaxArea {
    public static int solution(int[] arr) {
        int[] leftSmallest = indexOfNearestSmallestToLeft(arr);
        int[] rightSmallest = indexOfNearestSmallestToRight(arr);
        int maxArea = 0;
        for (int i = 0; i < arr.length; i++) {
            int currMax = (rightSmallest[i] - leftSmallest[i] - 1) * arr[i];
            maxArea = Math.max(currMax, maxArea);
        }
        return maxArea;
    }

    private static int[] indexOfNearestSmallestToLeft(int[] arr) {
        int[] output = new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stk.isEmpty()) {
                output[i] = -1;
            } else if (arr[i] > arr[stk.peek()]) {
                output[i] = stk.peek();
            } else {
                while (!stk.isEmpty() && arr[i] < arr[stk.peek()]) {
                    stk.pop();
                }

                if (stk.isEmpty()) {
                    output[i] = -1;
                } else {
                    output[i] = stk.peek();
                }
            }
            stk.push(i);
        }
        return output;
    }

    private static int[] indexOfNearestSmallestToRight(int[] arr) {
        int[] output = new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if (stk.isEmpty()) {
                output[i] = -1;
            } else if (arr[i] > arr[stk.peek()]) {
                output[i] = stk.peek();
            } else {
                while (!stk.isEmpty() && arr[i] < arr[stk.peek()]) {
                    stk.pop();
                }

                if (stk.isEmpty()) {
                    output[i] = -1;
                } else {
                    output[i] = stk.peek();
                }
            }
            stk.push(i);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};

        System.out.println(solution(arr));

    }

}
