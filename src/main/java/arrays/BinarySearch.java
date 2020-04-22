package arrays;

public class BinarySearch {
    public static int searchBS(int[] arr, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                start = mid + 1;

            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

}
