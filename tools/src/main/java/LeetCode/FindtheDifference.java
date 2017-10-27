package LeetCode;

public class FindtheDifference {

    public static char findTheDifference(String s, String t) {
        char c = t.charAt(0);
        for (int i = 1; i < t.length(); i++) c ^= t.charAt(i);
        for (int j = 0; j < s.length(); j++) c ^= s.charAt(j);
        return c;
    }

    public static void main(String[] args) {
        String s = "abcd", t = "acbde";
        System.out.println(findTheDifference(s, t));
    }

}
