package arrays;

public class LargestSumContiguousArray {
    public static int execute(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int maxLocalSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxLocalSum = Math.max(arr[i] + maxLocalSum, arr[i]);
            maxSum = Math.max(maxLocalSum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("MaxSum = " + execute(arr));
        System.out.println("MaxSum = " + execute(new int[]{-2, -1, -3, -4, -1, -2, 0, -5, -4}));
        System.out.println("MaxSum = " + execute(new int[]{10, 2, 3, 4, 5, 6}));
        System.out.println("MaxSum = " + execute(null));
        System.out.println("MaxSum = " + execute(new int[]{}));
    }
}
