package LeetCode;

public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return false;
        return validPalindrome(s, 0, s.length() - 1, 0);
    }

    private static boolean validPalindrome(String s, int lo, int hi, int count) {
        if (lo >= hi) return true;
        if (s.charAt(lo) == s.charAt(hi)) return validPalindrome(s, lo + 1, hi - 1, count);
        else if (count < 1)
            return validPalindrome(s, lo, hi - 1, count + 1) || validPalindrome(s, lo + 1, hi, count + 1);
        else return false;
    }

    public static void main(String[] args) {
        String s = "abcbea";
        System.out.println(validPalindrome(s));
    }

}
