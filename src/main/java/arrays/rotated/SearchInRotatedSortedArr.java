package arrays.rotated;

import arrays.BinarySearch;

public class SearchInRotatedSortedArr {
    public int search(int[] nums, int target) {
        int pivotIndex = findPivot(nums, 0, nums.length);

        System.out.println("Pivot Index = "+ pivotIndex);

        if (nums[0] <= target && target <= nums[pivotIndex]) {
            return BinarySearch.searchBS(nums, 0, pivotIndex, target);
        } else {
            return BinarySearch.searchBS(nums, pivotIndex + 1, nums.length - 1, target);
        }
    }


    private int findPivot(int[] arr, int start, int end) {
        if (start >= end) return -1;
        int mid = (start + end) / 2;
        if (arr[mid] > arr[mid + 1]) {
            return mid;
        }

        //pivot lies in the right sub array
        if (arr[start] < arr[mid]) {
            return findPivot(arr, mid + 1, end);
        }

        return findPivot(arr, start, mid);
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArr().search(new int[]{3, 4, 5, 6, 7, 0, 1, 2}, 5));
    }

}
