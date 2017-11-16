package LeetCode;

public class QueueReconstructionbyHeight {

    public static void reconstructQueue(int[][] people) {
        int R = 1100;
        for (int id = 1; id >= 0; id--) {
            int[] c = new int[R + 1];
            int[][] aux = new int[people.length][people[0].length];
            for (int i = 0; i < people.length; i++) c[people[i][id] + 1]++;
            for (int i = 1; i < c.length; i++) c[i] += c[i - 1];
            for (int i = 0; i < people.length; i++)
                for (int j = 0; j < people[0].length; j++)
                    aux[i][j] = people[i][j];
            for (int i = 0; i < aux.length; i++) {
                people[c[aux[i][id]]][0] = aux[i][0];
                people[c[aux[i][id]]][1] = aux[i][1];
                c[aux[i][id]]++;
            }
        }

        for (int i = people.length - 1; i >= 0; i--) {
            int j;
            if (i > 0 && people[i][0] == people[i - 1][0]) j = people[i][1] - people[i - 1][1] - 1;
            else j = people[i][1];
            int k = i + 1;
            int[] tmp = people[i];
            while (k < people.length && j > 0) {
                people[k - 1] = people[k];
                j--;
                k++;
            }
            people[--k] = tmp;
        }
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        reconstructQueue(people);
        System.out.println(people);
    }
}
