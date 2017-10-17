package LeetCode;

public class DifferenceSet {

    public static Node diff(Node s, Node t) {
        Node head = s, start = s, before = null;
        while (start != null) {
            Node ts = t;
            while (ts != null && ts.val != start.val) ts = ts.next;
            if (ts == null) before = start;
            else if (before != null) before.next = start.next;
            else head = start.next;
            start = start.next;
        }
        return head;
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
        t.next = n7;
        n7.next = n8;
        n8.next = n9;

        Node n = diff(s, t);
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
    }

}

