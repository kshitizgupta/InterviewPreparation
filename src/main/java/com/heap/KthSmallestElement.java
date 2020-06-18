package com.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    static Integer getKthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, Collections.reverseOrder());

        if (arr.length < k) {
            return -1;
        }
        for (int value : arr) {
            if (maxHeap.size() < k) {
                maxHeap.add(value);
            } else {
                if (maxHeap.peek() > value) {
                    maxHeap.remove();
                    maxHeap.add(value);
                }
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {10, 2, 9, 4, 5, 3, 7, 8, 6, 1};

        System.out.println("Output = " + getKthSmallestElement(arr, 4));
    }
}
