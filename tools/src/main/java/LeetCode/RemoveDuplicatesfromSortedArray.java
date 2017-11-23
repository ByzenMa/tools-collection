package LeetCode;

public class RemoveDuplicatesfromSortedArray {

    public static int removeDuplicates(int[] nums) {
        int n = nums.length, tail = 0;
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1, tmp = nums[j];
            for (; j > tail + 1 && tmp > nums[j - 1]; j--) nums[j] = nums[j - 1];
            if (j < i + 1) nums[j] = tmp;
            if (nums[j] > nums[j - 1]) tail++;
        }
        return tail + 1;
    }


    public static void main(String[] args) {
        int[] in = {1, 1, 2, 2, 3, 3, 3, 3, 4};
        System.out.println(removeDuplicates(in));
    }
}
