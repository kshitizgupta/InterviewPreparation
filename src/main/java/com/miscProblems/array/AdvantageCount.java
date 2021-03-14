package com.miscProblems.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 *
 * Return any permutation of A that maximizes its advantage with respect to B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 * Example 2:
 *
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 *
 *
 * Note:
 *
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 */
public class AdvantageCount {
    public int[] advantageCount(int[] A, int[] B) {
        int[] out = new int[A.length];
        Arrays.sort(A);
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < B.length; i++) {
            final int index = findElement(A, B[i], visited, 0, A.length-1);
            if(index == -1) {
                for(int j=0; j<A.length; j++) {
                    if(!visited.contains(j)) {
                        out[i] = A[j];
                        visited.add(j);
                        break;
                    }
                }
            } else {
                out[i] = A[index];
                visited.add(index);
            }
        }
        return out;
    }

    public int findElement(int[] A, int curr, Set<Integer> visited, int start, int end) {
        if(start > end) return -1;
        int recordSol = -1;
        int mid = (start + end) / 2;
        if (A[mid] > curr) {
            if (!visited.contains(mid)) {
                recordSol = mid;
                int inLeftSubArray = findElement(A, curr, visited, start, mid - 1);
                if (inLeftSubArray != -1) {
                    recordSol = inLeftSubArray;
                }
            } else {
                recordSol = findElement(A, curr, visited, start, mid - 1);
                if (recordSol == -1)
                    recordSol = findElement(A, curr, visited, mid + 1, end);
            }
        } else {
            recordSol = findElement(A, curr, visited, mid + 1, end);
        }

        return recordSol;
    }

    public static void main(String[] args) {
        AdvantageCount adv = new AdvantageCount();
        //        System.out.println(Arrays.toString(adv.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
//        System.out.println(Arrays.toString(adv.advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2})));
//        System.out.println(Arrays.toString(adv.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
        System.out.println(Arrays.toString(adv.advantageCount(new int[]{5621,1743,5532,3549,9581}, new int[]{913,9787,4121,5039,1481})));
    }
}
