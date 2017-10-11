package LeetCode;

public class Manacher {


    public static int manacher(String in) {
        int N = in.length();
        int[] p = new int[N];
        int id = 0, mx = 0;

        for (int i = 0; i < N; i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i >= p[i] && i < N - p[i] && in.charAt(i - p[i]) == in.charAt(i + p[i])) p[i]++;
            if (i + p[i] > mx) {
                mx = p[i] + i;
                id = i;
            }
        }

        int max = 0;
        for (int e : p) {
            if (max < e) max = e;
        }
        return max - 1;
    }


    public static void main(String[] args) {
        String s = "$#1#2#2#1#2#3#2#1#";
        System.out.println(manacher(s));
    }
}
