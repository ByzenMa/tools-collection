package LeetCode;

public class CharOnce {

    public static char getOnce(String s) {
        int[] count = new int[225];
        Character myChar = null;
        for (int i = 0; i < s.length(); i++) count[s.charAt(i)]++;
        for (int i = 0; i < s.length(); i++)
            if (count[s.charAt(i)] == 1) return s.charAt(i);
        return myChar;
    }

    public static void main(String[] args) {
        String s = "abaccdeff";
        System.out.println(getOnce(s));
    }
}
