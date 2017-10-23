package LeetCode;

public class FindAllSubStr {

    public static void print(String s, int h) {
        if (h == s.length()) return;
        int N = s.length();
        for (int i = h + 1; i <= N; i++) {
            String sub = s.substring(h, i);
            if (Integer.parseInt(sub) % 3 == 0) System.out.println(sub);
        }
        print(s, h + 1);

    }


    public static void main(String[] args) {
        String s = "012345";
        print(s, 0);
    }
}
