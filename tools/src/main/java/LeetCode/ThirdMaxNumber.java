package LeetCode;

import java.util.Arrays;

public class ThirdMaxNumber {

    public int thirdMax(int[] nums) {
        int len = nums.length;
        if (len == 1) return nums[0];
        if (len == 2) return nums[0] > nums[1] ? nums[0] : nums[1];

        Arrays.sort(nums, 0, 3);
        int third = nums[0], second = nums[1], first = nums[2];

        for (int i = 3; i < len; i++) {
            int e = nums[i];
            if (first < e) first = e;
            else if (second < e) second = e;
            else if (third < e) third = e;
        }
        return third;
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 1};
        ThirdMaxNumber test = new ThirdMaxNumber();
        System.out.println(test.thirdMax(a));
    }
}
