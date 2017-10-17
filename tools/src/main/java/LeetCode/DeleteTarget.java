package LeetCode;

public class DeleteTarget {

    public static String delete(String s, String t) {
        int[] c = new int[225];
        for (int i = 0; i < t.length(); i++) c[t.charAt(i)]++;
        String d = "";
        for (int j = 0; j < s.length(); j++) if (c[s.charAt(j)] == 0) d += s.charAt(j);
        return d;
    }

    public static void main(String[] args) {
        String s = "They are students.";
        String t = "aeiou";
        System.out.println(delete(s, t));
    }
}
