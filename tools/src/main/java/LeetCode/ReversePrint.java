package LeetCode;

public class ReversePrint {
    public static void print(Node r) {
        if (r.next == null) {
            System.out.println(r.val);
            return;
        }
        print(r.next);
        System.out.println(r.val);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;
        print(n1);
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }
}
