package miscProblems.arrayBased;

import java.util.HashMap;
import java.util.Map;

/**
 * Brute force approach is to find all contiguous sub-arrays. Now record all the sub-arrays with
 * sum 0 and find the max length out of all these sub-arrays.
 * Complexity here would be O(n^2).
 *
 * How can we reduce the complexity of this array. Lets iterate through the array and see what all can we do
 *
 * Lets say we have an array.
 * {1, 15, -2, 2, -8, 1, 7, 10, 23}
 * Lets try iterating through the array
 *
 * 1. 1, currSum=1
 * 2. 15, currSum=16
 * 3. -2, currSum=14
 * 4. 2, currSum=16
 * Now if we look closely we have this sum again 16. Which means that whatever lied between the previous occurrence
 * of 16 and this occurrence would sum to 0. And we can find the length of this sub array easliy if we can somehow
 * record the previous existences of this sum. Since we are looking for the max length of sub array, we can find
 * our desired result by only knowing the oldest occurrence of the sum. To store this we can use a ds like
 * HashMap.
 *
 * Below is the algo.
 *
 */
public class LargestContiguousSubArrayWithSum0 {
    public static int execute(int[] arr) {
        int maxLength = 0;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (!hm.containsKey(sum)) {
                hm.put(sum, i);
            } else {
                maxLength = i - hm.get(sum);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println("Max length = " + execute(new int[]{1, 15, -2, 2, -8, 1, 7, 10, 23}));
        System.out.println("Max length = " + execute(new int[]{15, -2, 2, -8, 1, 7, -15, 10, 23}));
        System.out.println("Max length = " + execute(new int[]{1, 0, 3}));
        System.out.println("Max length = " + execute(new int[]{1, 0, 0, 3}));

    }
}
