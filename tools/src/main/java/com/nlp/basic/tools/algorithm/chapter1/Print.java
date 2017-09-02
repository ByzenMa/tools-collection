package com.nlp.basic.tools.algorithm.chapter1;

import static junit.framework.TestCase.assertEquals;

/**
 * Question chapter1.1.3
 */
public class Print {

    public static void main(String[] args) {
        testEquals(args);
        toBinaryString(5);
        printResult();
        printMatrixTrans();
        printLog(5);
        int[] a = {1, 2, 3, 4, 2, 3, 1};
        bucket(a, 5);
        F(100);
        printLg(10);
        printGcd();
        int[] b = {1, 1, 2, 2, 3, 3, 3, 4, 4, 5};
        ltRank(3, b);
        printPrime(5);
        printStr();
        circularRotation("ACTGACG", "ACTGACG");
        printReverse();
    }

    static void testEquals(String[] args) {
        assertEquals(args.length, 3);
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);
        if (a == b && a == c) {
            System.out.println("equals");
        } else {
            System.out.println("not equals");
        }
    }

    static void toBinaryString(int i) {
        // Print by in-build method
        StringBuilder b = new StringBuilder();
        String str = b.append(Integer.toBinaryString(i)).toString();
        System.out.println(str);

        String s = "";
        for (int j = i; j > 0; j /= 2) {
            s = j % 2 + s;
        }
        System.out.println(s);
    }

    static void printResult() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    static void printMatrixTrans() {
        System.out.println();
        int[][] a = new int[4][5];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] = (int) (Math.random() * 10);
                if (j == a[0].length - 1) {
                    System.out.println(a[i][j]);
                } else {
                    System.out.print(a[i][j] + " ");
                }
            }
        }

        System.out.println();

        for (int i = 0; i < a[0].length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (j == a.length - 1) {
                    System.out.println(a[j][i]);
                } else {
                    System.out.print(a[j][i] + " ");
                }
            }
        }
    }

    static void printLog(int N) {
        System.out.println();
        int x = 0;
        int exp = 1;
        while (exp <= N) {
            exp *= 2;
            x++;
        }
        x--;
        System.out.println(x);
    }

    static void bucket(int[] a, int M) {
        System.out.println();
        int[] bucket = new int[M];

        for (int i = 0; i < a.length; i++) {
            if (a[i] < M) {
                bucket[a[i]]++;
            }
        }

        for (int j : bucket) {
            System.out.print(j + " ");
        }
    }

    static void F(int N) {
        System.out.println();
        long[] history = new long[N + 1];
        history[0] = 0;
        history[1] = 1;

        for (int i = 2; i <= N; i++) {
            history[i] = history[i - 1] + history[i - 2];
        }
        System.out.println(history[N]);
    }

    static double logRecusive(int N) {
        if (N == 1) return 0;
        double lgn = Math.log(N) + logRecusive(N - 1);
        return lgn;
    }

    static void printLg(int N) {
        System.out.println();
        System.out.println(logRecusive(N));
    }

    static int gcd(int p, int q) {
        System.out.print(p + " ");
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    static void printGcd() {
        System.out.println();
        System.out.println(gcd(105, 24));
    }

    static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] < key) hi = mid - 1;
            else if (a[mid] > key) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    static void ltRank(int key, int[] a) {
        System.out.println();
        int idx = rank(key, a);
        if (idx == -1) {
            System.out.println("Null");
        } else {
            int rank = idx - 1;
            while (rank >= 0) {
                if (a[rank] != a[idx]) {
                    break;
                }
                rank--;
            }
            System.out.println(rank + 1);
        }
    }

    static boolean isCoprime(int a, int b) {
        int min = a < b ? a : b;
        for (int i = 2; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void printPrime(int N) {
        System.out.println();
        boolean[][] b = new boolean[N][N];
        for (int i = 2; i < N; i++) {
            for (int j = 2; j < N; j++) {
                b[i][j] = isCoprime(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            b[0][i] = false;
            b[i][0] = false;
        }

        for (int i = 1; i < N; i++) {
            b[1][i] = false;
            b[i][1] = false;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j == N - 1) {
                    System.out.println(b[i][j]);
                } else {
                    System.out.print(b[i][j] + " ");
                }
            }
        }
    }

    static void printStr() {
        System.out.println();
        String str1 = "Hello";
        String str2 = str1;
        str1 = " word!";
        System.out.println(str2 + str1);
    }

    static void circularRotation(String a, String b) {
        System.out.println();
        System.out.println(a.length() == b.length() && a.concat(a).indexOf(b) >= 0);
    }


    static String reverse(String input) {
        int len = input.length();
        if (len <= 1) return input;
        String a = input.substring(0, len / 2);
        String b = input.substring(len / 2);
        return reverse(b) + reverse(a);
    }

    static void printReverse() {
        System.out.println();
        System.out.println(reverse("abcd"));
    }

}
