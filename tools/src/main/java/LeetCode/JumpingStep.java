package LeetCode;

public class JumpingStep {
    public static int step(int n) {
        int f = 1, s = 2;
        for (int i = 3; i <= n; i++) {
            s = s + f;
            f = s - f;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(step(5));
    }
}
