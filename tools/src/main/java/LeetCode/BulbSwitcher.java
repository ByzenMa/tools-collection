package LeetCode;

public class BulbSwitcher {

    public static int bulbSwitch(int n) {
        int[] b = new int[n + 1];
        for (int i = 1; i <= n; i++)
            for (int j = i; j <= n; j += i) b[j]++;

        int count = 0;
        for (int e : b) if (e % 2 == 1) count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(bulbSwitch(999999));
    }

}
