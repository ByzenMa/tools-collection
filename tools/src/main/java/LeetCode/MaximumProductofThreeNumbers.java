package LeetCode;

public class MaximumProductofThreeNumbers {

    public static int maximumProduct(int[] nums) {
        int R = 2001, total = 3, r = 1;
        int[] c = new int[R];
        for (int e : nums) c[e + 1000]++;
        for (int i = R - 1; i >= 0; i--) {
            while (c[i]-- > 0 && total-- > 0)
                r *= (i - 1000);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1000, 1000, 1000};
        System.out.println(maximumProduct(nums));
    }
}
