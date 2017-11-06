package LeetCode;

public class ReverseWordsinaString {

    public static String reverseWords(String s) {
        s = reverseStr(s);
        String[] ss = s.split(" ");
        String r = "";
        for (int i = 0; i < ss.length; i++) {
            if (ss[i].trim().length() > 0) {
                r += reverseStr(ss[i]);
                if (i != ss.length - 1) r += " ";
            }
        }
        return r.trim();
    }

    private static String reverseStr(String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            char tmp = cs[i];
            cs[i++] = cs[j];
            cs[j--] = tmp;
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        String s = "   a   b ";
        System.out.println(reverseWords(s));
    }
}
