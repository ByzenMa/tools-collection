package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray {

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) continue;
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) r.add(i + 1);
        }
        return r;
    }

    public static void main(String[] args) {
        int[] x = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(x));
    }

}
