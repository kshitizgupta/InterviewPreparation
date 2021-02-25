package com.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreatestElementToLeft {
    public static int[] solution(int[] arr) {
        int[] output = new int[arr.length];
        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if (stk.isEmpty()) {
                output[i] = -1;
            } else if (arr[i] < stk.peek()) {
                output[i] = stk.peek();
            } else {
                while (!stk.isEmpty() && arr[i] >= stk.peek()) {
                    stk.pop();
                }

                if (stk.isEmpty()) {
                    output[i] = -1;
                } else {
                    output[i] = stk.peek();
                }
            }

            stk.push(arr[i]);
        }

        return output;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};

        System.out.println(Arrays.toString(solution(arr)));

        arr = new int[]{34, 35, 27, 42, 5, 28, 39, 20, 28};

        System.out.println(Arrays.toString(solution(arr)));
    }

}
