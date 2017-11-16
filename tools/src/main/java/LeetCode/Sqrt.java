package LeetCode;

public class Sqrt {

    public static int mySqrt(int x) {
        int b = 1;
        while (b * b <= x && b * b != 0) b++;
        return --b;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395600));
    }
}
