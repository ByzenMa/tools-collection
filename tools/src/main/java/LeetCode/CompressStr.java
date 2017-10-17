package LeetCode;

public class CompressStr {

    public static String compress(char[] s, int k) {
        if (k > s.length) return new String(s);
        int i = k;
        while (i < s.length && s[i] != ' ') i++;
        for (int h = k, t = i - 1; h < t; h++, t--) {
            char temp = s[h];
            s[h] = s[t];
            s[t] = temp;
        }
        return compress(s, k + 1);
    }

    public static void main(String[] args) {
        String s = "abc efg hij";
        System.out.println(compress(s.toCharArray(), 0));
    }

}
