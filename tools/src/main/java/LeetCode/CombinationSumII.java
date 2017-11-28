package LeetCode;

import java.util.*;

public class CombinationSumII {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> r = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return r;
        Arrays.sort(candidates);
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            if (s.contains(candidates[i])) continue;
            s.add(candidates[i]);
            List<Integer> once = new ArrayList<>();
            combinationSum2(candidates, r, once, i, 0, target);
        }
        return r;
    }

    private static void combinationSum2(int[] candidates, List<List<Integer>> r, List<Integer> once, int idx, int sum, int target) {
        if (sum + candidates[idx] > target) return;
        else if (sum + candidates[idx] == target) {
            once.add(candidates[idx]);
            r.add(once);
            return;
        } else {
            for (int i = idx + 1; i < candidates.length; i++) {
                List<Integer> n = new ArrayList<>();
                n.addAll(once);
                n.add(candidates[idx]);
                combinationSum2(candidates, r, n, i, sum + candidates[idx], target);
            }
        }
    }


    public static void main(String[] args) {
        int[] in = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(in, target));
    }
}
