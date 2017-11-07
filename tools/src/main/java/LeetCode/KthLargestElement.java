package LeetCode;

public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private static int findKthLargest(int[] nums, int lo, int hi, int k) {
        if (lo >= hi)
            if (k == 1) return nums[lo];
            else return -1;
        int p = partition(nums, lo, hi);
        if (hi - p + 1 == k) return nums[p];
        else if (hi - p + 1 > k) return findKthLargest(nums, p + 1, hi, k);
        else return findKthLargest(nums, lo, p - 1, k - hi + p - 1);
    }

    private static int partition(int[] nums, int lo, int hi) {
        int i = lo, j = hi + 1, v = nums[lo];
        while (true) {
            while (nums[++i] < v) if (i == hi) break;
            while (nums[--j] > v) if (j == lo) break;
            if (i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int temp = nums[lo];
        nums[lo] = nums[j];
        nums[j] = temp;
        return j;
    }

    public static void main(String[] args) {
        int[] in = {7, 6, 5, 4, 3, 2, 1};
//        Arrays.
        System.out.println(findKthLargest(in, 2));
    }
}
