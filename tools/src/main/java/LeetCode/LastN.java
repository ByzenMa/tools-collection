package LeetCode;

public class LastN {

    public static Node last(Node x, int n) {
        Node i = x, j = x;
        int k = 0;
        while (k < n) {
            j = j.next;
            k++;
        }
        while (j != null) {
            i = i.next;
            j = j.next;
        }
        return i;
    }

    public static void main(String[] args) {
        Node s = new Node(5);
        Node n2 = new Node(10);
        Node n3 = new Node(20);
        Node n4 = new Node(15);
        Node n5 = new Node(25);
        Node n6 = new Node(30);

        s.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        Node t = new Node(5);
        Node n7 = new Node(15);
        Node n8 = new Node(35);
        Node n9 = new Node(25);
        n6.next = t;
        t.next = n7;
        n7.next = n8;
        n8.next = n9;

        System.out.println(last(s, 2).val);
    }

}
