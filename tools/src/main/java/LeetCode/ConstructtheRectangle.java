package LeetCode;

public class ConstructtheRectangle {
    public static int[] constructRectangle(int area) {
        int w = (int) Math.sqrt(area);
        while (area % w != 0) w--;
        return new int[]{area / w, w};
    }
}
