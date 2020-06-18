package com.miscProblems.stackBased;

import java.util.Stack;

/**
 * Find the largest rectangular area possible in a given histogram where the largest rectangle can be made of a
 * number of contiguous bars. For simplicity, assume that all bars have same width and the width is 1 unit.
 * For example, consider the following histogram with 7 bars of heights {6, 2, 5, 4, 5, 1, 6}. The largest possible
 * rectangle possible is 12
 *
 * How to work out the algorithm:
 * In a brute force approach you want to take any element and expand it to left and right
 * as much as you can expand to get the max area. For example 5,4,3,4,2,1, if I pick 3 then I can expand it to
 * 5 in left and 4 in right to get the max area this 3 can make which is 3 * 4 bars = 12 unit area
 * If we do this for each element we get a time complexity of O(n^2)
 *
 * Our motive is to device an O(n) solution for this problem. So we need to iterate on the array once.
 * For a given element we can expand to the right until the elements to the right are >= the current element.
 * When we encounter an element less than the current element it means, that the current element can not expand
 * to get more area into this new element which is supposed to be introduced. Hence we can pick the current element
 * , calculate the amx area it can produce and remove it from our memory as we have already got the max area out of it.
 * We continue this calculate max area and remove it from out memory until the new element which is supposed to be
 * introduced is >= the most recent element in the memory. Say we have 1,2,3,4 in memory and new element to be introduced
 * is 1. So it means that 4 cant expand into 1 so we calculate the amx area for 4 which is 4*1 and remove 4 from our memory.
 * Now we are left with 3 which too cant expand into 1 so we calculate max area for 3. Remember 3 could have expanded to
 * 4 which we removed earlier so max area for 3 is 3*2. Similarly we calculate max area made by 2 and remove it too.
 * Now we can insert 1 in our memory and it looks like 1,1 now. And then we move ahead with more elements
 *
 * Now there could be a case when we are eft with some bars in memory at the end of our iteration. In the above example if
 * the input arr finishes by 1 then we have 1,1 in our memory and we need to compute the max area by these elements as well
 *
 * Since we are storing bars in memory, what data structure can we use. If we see closely we are mainly concerned
 * with the recent most element in the memory, which sounds like top of a stack. So we are going to be using this in our solution
 */
public class MaxAreaOfHistogram {

    public static int getMaxArea(int[] histogram) {
        if (histogram.length == 0) return 0;
        int maxArea = 0;
        Stack<Integer> indicesStack = new Stack<>();
        for (int i = 0; i < histogram.length; ) {
            if (indicesStack.isEmpty() || histogram[i] >= histogram[indicesStack.peek()]) {
                indicesStack.push(i++);
            } else {
                int poppedIndex = indicesStack.pop();
                int currMaxArea;
                if (indicesStack.isEmpty()) {
                    currMaxArea = histogram[poppedIndex] * i;
                } else {
                    currMaxArea = histogram[poppedIndex] * (i - 1 - indicesStack.peek());
                }

                maxArea = Math.max(maxArea, currMaxArea);
            }
        }
        while (!indicesStack.isEmpty()) {
            int poppedIndex = indicesStack.pop();
            int currMaxArea;
            if (indicesStack.isEmpty()) {
                currMaxArea = histogram[poppedIndex] * histogram.length;
            } else {
                currMaxArea = histogram[poppedIndex] * (histogram.length - 1 - indicesStack.peek());
            }
            maxArea = Math.max(maxArea, currMaxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println("Max Area = " + getMaxArea(new int[]{1, 2, 3, 4, 5, 3, 3, 2}));
        System.out.println("Max Area = " + getMaxArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
        System.out.println("Max Area = " + getMaxArea(new int[]{2, 5, 3, 2}));
        System.out.println("Max Area = " + getMaxArea(new int[]{4, 2, 1}));
        System.out.println("Max Area = " + getMaxArea(new int[]{11, 11, 10, 10, 10}));
    }
}
