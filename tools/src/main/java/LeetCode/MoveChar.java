package LeetCode;

public class MoveChar {

    public static String move(String s) {
        int n = s.length();
        char[] c = s.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            int j = i + 1;
            char temp = c[j];
            while (j > 0 && temp < 'A' && c[j - 1] >= 'A') {
                c[j] = c[j - 1];
                j--;
            }
            if (j < i + 1) c[j] = temp;
        }

        return new String(c);
    }


    public static void main(String[] args) {
        String s = "as2d3f1A5D4a";
        System.out.println(move(s));
    }
}
