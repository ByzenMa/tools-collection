package LeetCode;

public class MaxSerialString {

    public static int maxSub(String s1) {
        if (s1.length() == 0) return 0;
        int max = 1, i = 1;
        while (i < s1.length() && s1.charAt(i) == s1.charAt(i - 1)) {
            i++;
            max++;
        }
        String newS = s1.substring(i);
        return Math.max(max, maxSub(newS));
    }

    public static void main(String[] args) {
        String s = "aaaabbcc";
        System.out.println(maxSub(s));
    }

}
