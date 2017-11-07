package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < nums.length; i++)
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1, m = nums.length - 1;
                while (k < m) {
                    int sum = nums[k] + nums[m] + nums[i] + nums[j];
                    if (sum == target) r.add(addToList(nums[i], nums[j], nums[k++], nums[m--]));
                    else if (sum > target) m--;
                    else k++;
                }
            }
        return r;
    }

    private static List<Integer> addToList(int i, int j, int k, int m) {
        List<Integer> ls = new ArrayList<>();
        ls.add(i);
        ls.add(j);
        ls.add(k);
        ls.add(m);
        return ls;
    }

    public static void main(String[] args) {
        int[] x = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> r = fourSum(x, 0);
        System.out.println(r);
        String s = "abc";
    }
}
