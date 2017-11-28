package LeetCode;

public class AddTwoNumbersII {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n1 = 0, n2 = 0;
        while (l1 != null) {
            n1 = 10 * n1 + l1.val;
            l1 = l1.next;
        }
        while (l2 != null) {
            n2 = 10 * n2 + l2.val;
            l2 = l2.next;
        }
        int sum = n1 + n2;
        ListNode head = null;
        while (sum != 0) {
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            sum /= 10;
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(4);
        n5.next = n6;
        n6.next = n7;

        System.out.println(addTwoNumbers(n1, n5));
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
