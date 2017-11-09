package LeetCode;

public class RemoveDuplicatesfromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        if (next.val != head.val) head.next = deleteDuplicates(next);
        else {
            while (next != null && next.val == head.val) next = next.next;
            if (next == null) head = null;
            else {
                head.val = next.val;
                head.next = next.next;
            }
            head = deleteDuplicates(head);
        }
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(2);
        n1.next = n2;
//        n2.next = n3;
        ListNode root = deleteDuplicates(n1);
        System.out.println(root.val);
    }
}
