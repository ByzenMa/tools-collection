package LeetCode;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] mul = new int[n1 + n2];
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < n2; j++) {
                int m = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int f = m / 10, s = m % 10;
                mul[i + j + 1] += s;
                mul[i + j] += f;
            }
        int add = 0;
        for (int i = n1 + n2 - 1; i >= 0; i--) {
            int left = (mul[i] + add) / 10;
            mul[i] = (mul[i] + add) % 10;
            add = left;
        }

        String sb = "";
        for (int e : mul) sb += e;
        if (sb.startsWith("0")) sb = sb.substring(1);
        return sb;
    }

    public static void main(String[] args) {
        String n1 = "123";
        String n2 = "456";
        System.out.println(multiply(n1, n2));
    }
}
