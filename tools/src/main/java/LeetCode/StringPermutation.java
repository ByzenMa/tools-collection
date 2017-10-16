package LeetCode;

public class StringPermutation {

    public static void permutation(char[] s, int from, int to) {
        if (to <= 1)
            return;
        if (from == to) {
            System.out.println(s);
        } else {
            for (int i = from; i <= to; i++) {
                swap(s, i, from); //交换前缀，使其产生下一个前缀
                permutation(s, from + 1, to);
                swap(s, from, i); //将前缀换回，继续做上一个前缀的排列
            }
        }
    }

    public static void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }

    public static void permutationAll(char[] s, String total) {
        if (total.length() == s.length) {
            System.out.println(total);
            return;
        }
        for (int i = 0; i < s.length; i++) {
            String newT = total + s[i];
            permutationAll(s, newT);
        }
    }

    public static void combination(char[] s, int start, String total) {
        if (total.length() == s.length) return;
        for (int i = start; i < s.length; i++) {
            String newT = total + s[i];
            System.out.println(newT);
            combination(s, ++start, newT);
        }
    }

    public static void combination2(char[] s, int start, String total) {
        if (total.length() == s.length) return;
        for (int i = start; i < s.length; i++) {
            String newT = total + s[i];
            System.out.println(newT);
            combination(s, ++start, newT);
        }
    }

    public static void printCombination(char[] s) {

    }


    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c'};
//        permutation(s, 0, 2);
//        permutationAll(s, "");
        combination2(s, 0, "");
    }
}
