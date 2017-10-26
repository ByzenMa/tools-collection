package LeetCode;

public class MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {
        int c = 0, mx = 0;
        for (int e : nums) {
            if (e == 1) c++;
            else c = 0;
            if (mx < c) mx = c;
        }
        return mx;
    }

    public static void main(String[] args) {
        int[] x = {1, 1};
        System.out.println(findMaxConsecutiveOnes(x));
    }
}
