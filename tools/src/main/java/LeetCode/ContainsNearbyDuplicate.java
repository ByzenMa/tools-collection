package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class ContainsNearbyDuplicate {

    public static boolean find(int[] x, int k) {
        int N = x.length;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (x[i] == x[j] && Math.abs(j - i) <= k) return true;
            }
        return false;
    }

    public static boolean find2(int[] nums, int k) {
        int N = nums.length;
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < N - i; j++) {
                if (nums[j] == nums[j + i]) return true;
            }
        }
        return false;
    }

    public static boolean find3(int[] nums, int k) {
        int N = nums.length;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            if (!map.containsKey(nums[i])) map.put(nums[i], i);
            else {
                if (Math.abs(map.get(nums[i]) - i) <= k) return true;
                else map.put(nums[i], i);
            }
        }
        return false;
    }

    public static boolean find4(int[] nums, int k) {
        int N = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            if (i > k) set.remove(nums[i - k - 1]);
            if (!set.add(nums[i])) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 42, 4, 2, 3, 5};
        System.out.println(find4(x, 4));
    }
}
