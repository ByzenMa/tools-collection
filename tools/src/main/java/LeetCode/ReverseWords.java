package LeetCode;


import java.util.Stack;

public class ReverseWords {

    public static String reverse(String s) {
        int N = s.length();
        Stack<Character> stk = new Stack<>();
        for (int i = N - 1; i >= 0; i--) stk.push(s.charAt(i));
        Stack<Character> stk2 = new Stack<>();
        String r = "";
        while (!stk.isEmpty()) {
            char c = stk.pop();
            if (c == ' ') {
                while (!stk2.isEmpty()) r += stk2.pop();
                r += c;
            } else stk2.push(c);
        }

        while (!stk2.isEmpty()) r += stk2.pop();
        return r;
    }

    public static String reverse2(String s) {
        int N = s.length(), h = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == ' ') {
                revs(c, h, i - 1);
                h = i + 1;
            }
        }
        revs(c, h, N - 1);
        return new String(c);
    }

    public static void revs(char[] c, int from, int to) {
        while (from < to) {
            char tmp = c[from];
            c[from++] = c[to];
            c[to--] = tmp;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverse2(s));
    }

}
