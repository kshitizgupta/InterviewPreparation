package arrays;

public class LargestSumContiguousArrWithIndices {
    public static SubArray execute(int[] arr) {
        int startIndex = 0;
        int endIndex = 0;
        int localMax = arr[0];
        int globalMax = arr[0];
        SubArray res = new SubArray();
        for (int i = 1; i < arr.length; i++) {
            localMax = Math.max(arr[i], arr[i] + localMax);
            if (globalMax < localMax) {
                endIndex = i;
                globalMax = localMax;
            }
        }
        res.endIndex = endIndex;
        res.sum = globalMax;
        for (int i = endIndex; i >= 0; i--) {
            globalMax -= arr[i];
            if (globalMax == 0) {
                startIndex = i;
                break;
            }
        }
        res.startIndex = startIndex;
        return res;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println(execute(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(execute(new int[]{-2, 5, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(execute(new int[]{-2, -1, -3, -4, -1, -2, 0, -5, -4}));
    }

}
