package LeetCode;

public class ReverseInteger {

    public static int reverse(int x) {

        int result = 0;

        while(x != 0) {
            int old = result;
            int tail = x %10;
            result = result *10 + tail;
            if((result-tail)/10 != old) return 0;
            x = x/10;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(100));
    }
}
