package LeetCode;

import java.util.Stack;

public class CalPoints {

    public static int cal(String[] ops) {
        Stack<Integer> s = new Stack<>();
        int sum = 0;
        for (String e : ops) {
            if (e.equals("C")) sum -= s.pop();
            else if (e.equals("D")) {
                s.push(s.peek() * 2);
                sum += s.peek();
            } else if (e.equals("+")) {
                int last = s.pop(), add = last + s.peek();
                s.push(last);
                s.push(add);
                sum += s.peek();
            } else {
                s.push(Integer.parseInt(e));
                sum += s.peek();
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(cal(ops));
    }

}
