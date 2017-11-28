package LeetCode;

import java.util.*;

public class _3Sum {


    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> r = new ArrayList<>();
        Set<List<Integer>> ls = new HashSet<>();
        if (nums == null || nums.length == 0) return r;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int left = -nums[i];
            int j = i + 1, k = n - 1;
            while (j < k) {
                if (nums[j] + nums[k] == left) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j++]);
                    l.add(nums[k--]);
                    ls.add(l);
                } else if (nums[j] + nums[k] > left) k--;
                else j++;
            }
        }
        r.addAll(ls);
        return r;
    }

    public static void main(String[] args) {

        int[] in = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(in));
    }

}
