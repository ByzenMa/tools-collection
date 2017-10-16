package LeetCode;

public class Manacher2 {

    public static String max(String s) {
        int id = 0, mx = 0, max = 0, mxId = 0;
        int[] p = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (i >= p[i] && i < s.length() - p[i] && s.charAt(i + p[i]) == s.charAt(i - p[i])) p[i]++;
            if (mx < i + p[i]) {
                id = i;
                mx = id + p[i];
            }
            if (p[i] > max) {
                max = p[i];
                mxId = i;
            }
        }

        String o = "";
        int i = 1;
        while (i < max) {
            o = s.charAt(mxId - i) + o;
            o += s.charAt(mxId + i);
            i++;
        }

        String out = "";
        for (int k = 0; k < o.length(); k++)
            if (o.charAt(k) != '#') out += o.charAt(k);

        return out;
    }

    public static void main(String[] args) {
        String s = "#g#o#o#g#l#e";
        System.out.println(max(s));
    }

}
