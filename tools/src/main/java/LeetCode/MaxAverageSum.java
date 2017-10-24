package LeetCode;

public class MaxAverageSum {
    public static double findMaxAverage(int[] nums, int k) {
        if (k <= 0) return -1;
        double s = sum(nums, 0, k - 1), mx = s;
        for (int i = k; i < nums.length; i++) {
            s = s + nums[i] - nums[i - k];
            if (s > mx) mx = s;
        }
        return mx / k;
    }

    public static double sum(int[] nums, int from, int to) {
        if (from > to) return -1;
        int sum = 0;
        for (int i = from; i <= to; i++) sum += nums[i];
        return sum;
    }

    public static void main(String[] args) {
        int[] s = {4, 2, 1, 3, 3};
        System.out.println(findMaxAverage(s, 2));
    }
}
