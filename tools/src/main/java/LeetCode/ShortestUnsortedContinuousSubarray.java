package LeetCode;

public class ShortestUnsortedContinuousSubarray {

    public static int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) return 0;
        int i = 0, j = nums.length - 1;
        while (nums[i] < nums[i + 1] && i < nums.length - 1) i++;
        while (nums[j] > nums[j - 1] && j > 0) j--;
        return j - i + 1;
    }

    public static void main(String[] args) {
        int[] x = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(x));

        String  s = "abc";
        s.toCharArray();
    }


}
