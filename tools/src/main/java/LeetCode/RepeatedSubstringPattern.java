package LeetCode;

public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) return false;
        int k = 2;
        while (k <= s.length()) {
            if (s.length() % k != 0) {
                k++;
                continue;
            }
            for (int i = 0, j = s.length() / k; j <= s.length(); i += s.length() / k, j += s.length() / k) {
                if (j == s.length()) return true;
                String head = s.substring(i, j);
                String left = s.substring(j);
                if (!left.startsWith(head)) break;
            }
            k++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "bb";
        System.out.println(repeatedSubstringPattern(s));
    }

}
