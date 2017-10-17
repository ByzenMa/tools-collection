package LeetCode;

public class CountChar {

    public static void count(String s) {
        int[] count = new int[225];
        for (int i = 0; i < s.length(); i++) count[s.charAt(i)]++;
        for (int i = 0; i < count.length; i++)
            if (count[i] > 0)
                System.out.println((char) i + "\t" + count[i]);
    }

    public static void main(String[] args) {
        String s = "AbcABca";
        count(s);
    }
}
