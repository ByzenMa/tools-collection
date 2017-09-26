package LeetCode;

import java.util.Arrays;

public class RotatedSortedArray {

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    int search(int[] nums, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) {
            if (target == nums[lo]) return lo;
            else if (target > nums[lo] || (target < nums[lo] && nums[lo] > nums[mid])) return search(nums, lo, mid - 1, target);
            else return search(nums, mid + 1, hi, target);
        } else {
            if (target == nums[hi]) return hi;
            else if ((target > nums[hi] && nums[mid] > nums[hi]) || target < nums[hi]) return search(nums, mid+1, hi, target);
            else return search(nums, lo, mid-1, target);
        }
    }

    public static void main(String[] args) {
//        int[] a = {1, 3};
        RotatedSortedArray test = new RotatedSortedArray();
//        System.out.println(test.search(a, 3));

        int[] b = {4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(test.search(b, 8));
        Arrays.sort(b);
    }
}
