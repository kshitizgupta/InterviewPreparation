package com.slidingWindow;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FirstNegativeElementInWindow {
    public static int[] solution(int[] arr, int k) {
        int i = 0, j = 0;
        Queue<Integer> negatives = new LinkedList<>();
        for (; j < k; j++) {
            if (arr[j] < 0)
                negatives.offer(arr[j]);
        }

        j--;
        int[] output = new int[arr.length - k + 1];
        while (j < arr.length) {
            if (negatives.isEmpty()) {
                output[i] = 0;
            } else {
                output[i] = negatives.peek();
            }
            i++;
            j++;
            if (arr[i - 1] < 0) {
                negatives.poll();
            }
            if (j < arr.length && arr[j] < 0) {
                negatives.offer(arr[j]);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{12, -1, -7, 8, -15, 30, 16, 28}, 3)));
    }
}
