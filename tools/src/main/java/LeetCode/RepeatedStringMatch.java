package LeetCode;

public class RepeatedStringMatch {

    public static int repeatedStringMatch(String A, String B) {
        int count = 1, mx = B.length() / A.length() + 2;
        String a = A;
        while (count <= mx) {
            if (a.contains(B)) return count;
            else {
                a += A;
                count++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String A = "abababaaba";
        String B = "aabaaba";
        System.out.println(repeatedStringMatch(A, B));
    }
}
