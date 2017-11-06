package LeetCode;

public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        for (int i = m - 1; i >= 0; i--) nums1[n + i] = nums1[i];
        int i = n, j = 0;
        for (int k = 0; k < m + n; k++) {
            if (i >= m + n) nums1[k] = nums2[j++];
            else if (j >= n) break;
            else {
                if (nums1[i] < nums2[j]) nums1[k] = nums1[i++];
                else nums1[k] = nums2[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 5, 6, 0}, nums2 = {3};
        int m = 5, n = 1;
        merge(nums1, m, nums2, n);
        for (int e : nums1) System.out.println(e + " ");
    }



}
