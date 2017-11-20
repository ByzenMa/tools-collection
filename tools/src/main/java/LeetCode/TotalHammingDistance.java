package LeetCode;

public class TotalHammingDistance {

    public int totalHammingDistance(int[] nums) {
        int totalDistance = 0;
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++)
                totalDistance += Integer.bitCount(nums[i] ^ nums[j]);
        return totalDistance;
    }


    public static void main(String[] args) {
        String in = "abc";
        in.startsWith("a");
    }
}
