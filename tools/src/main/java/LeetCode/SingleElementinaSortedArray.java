package LeetCode;

public class SingleElementinaSortedArray {

    public static int singleNonDuplicate(int[] nums) {
        int r = 0;
        for (int e : nums) r ^= e;
        return r;
    }


    public static void main(String[] args) {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate(nums));
    }
}
