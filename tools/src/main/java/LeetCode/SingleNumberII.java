package LeetCode;

public class SingleNumberII {

    public static int singleNumber(int[] nums) {
        int r = 0;
        for (int i = 0; i < 2; i++)
            for (int e : nums) {
                r ^= e;
            }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 2};
        System.out.println(singleNumber(nums));
    }



}
