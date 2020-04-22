package arrays;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithSum0 {
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
        System.out.println("Max length = " + execute(new int[]{15, -2, 2, -8, 1, 7, 10, 23}));
        System.out.println("Max length = " + execute(new int[]{1, 0, 3}));
        System.out.println("Max length = " + execute(new int[]{1, 0, 0, 3}));

    }
}
