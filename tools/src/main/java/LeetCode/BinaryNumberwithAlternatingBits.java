package LeetCode;

public class BinaryNumberwithAlternatingBits {

    public static boolean hasAlternatingBits(int n) {
        return Integer.toBinaryString(n).matches("(10)*1?");
    }

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(5));
    }
}
