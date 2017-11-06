package LeetCode;

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] s1 = a.split("\\+");
        int n1 = Integer.parseInt(s1[0]);
        int n2 = Integer.parseInt(s1[1].substring(0, s1[1].length() - 1));
        String[] s2 = b.split("\\+");
        int m1 = Integer.parseInt(s2[0]);
        int m2 = Integer.parseInt(s2[1].substring(0, s2[1].length() - 1));
        StringBuilder sb = new StringBuilder();
        sb.append((n1 * m1 - n2 * m2) + "");
        sb.append("+");
        sb.append((n1 * m2 + n2 * m1) + "");
        sb.append("i");
        return sb.toString();
    }
}
