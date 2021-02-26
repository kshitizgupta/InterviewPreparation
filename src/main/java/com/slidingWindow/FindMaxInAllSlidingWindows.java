package com.slidingWindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class FindMaxInAllSlidingWindows {
    public static int[] solution(int[] arr, int k) {
        int i = 0, j = 0;
        int[] output = new int[arr.length - k + 1];
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (; j < k; j++) {
            queue.offer(arr[j]);
        }

        j--;

        while (j < arr.length) {
            output[i] = queue.peek();

            i++;
            j++;

            if (j < arr.length) {
                queue.offer(arr[j]);

            }
            queue.remove(arr[i - 1]);

        }

        return output;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(solution(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{9, 10, 9, -7, -4, -8, 2, -6}, 5)));
        System.out.println(Arrays.toString(solution(new int[]{-6,-10,-7,-1,-9,9,-8,-4,10,-5,2,9,0,-7,7,4,-2,-10,8,7}, 7)));
    }
}
