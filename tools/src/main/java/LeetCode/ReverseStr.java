package LeetCode;

public class ReverseStr {

    public static String reverse(String s) {
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while (i < j) {
            char temp = c[i];
            c[i++] = c[j];
            c[j--] = temp;
        }

        return new String(c);
    }


    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(reverse(s));
    }

}
