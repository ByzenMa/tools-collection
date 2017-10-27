package LeetCode;

public class CountBinarySubstrings {

    public static int count(String s) {
        int b = 0, c = 1, mx = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                mx += Math.min(b, c);
                b = c;
                c = 0;
            }
            c++;
        }
        mx += Math.min(b, c);
        return mx;
    }


    public static void main(String[] args) {
        System.out.println(count("00100"));
    }
}
