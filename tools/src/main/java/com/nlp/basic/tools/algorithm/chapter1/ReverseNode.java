package com.nlp.basic.tools.algorithm.chapter1;

public class ReverseNode {

    public class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node reverseIterately(Node x) {
        Node first = x;
        Node reverse = x.next;
        while (first != null) {
            Node second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }
        return reverse;
    }


    public Node reverseRecursively(Node x) {
        if (x == null) return null;
        if (x.next == null) return x;
        Node second = x.next;
        Node head = reverseRecursively(second);
        second.next = x;
        x.next = null;
        return head;
    }
}
