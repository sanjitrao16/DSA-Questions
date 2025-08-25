// Reverse a Linked List

// 1. Iterative + Recursive solution

public class LeetCode_206 {
    public static void main(String[] args) {
        ListNode ll6 = new ListNode(6);
        ListNode ll5 = new ListNode(5,ll6);
        ListNode ll4 = new ListNode(4,ll5);
        ListNode ll3 = new ListNode(3,ll4);
        ListNode ll2 = new ListNode(2,ll3);
        ListNode ll1 = new ListNode(1,ll2);

        ListNode head = reverseListRecursive(ll1);

        // Displaying the list
        while (head != null) {
            System.out.print(head.val+" -> ");
            head = head.next;
        }

        System.out.println("END");
    }

    static ListNode reverseList(ListNode node) {
        ListNode dummy = null;
        ListNode ptr2 = node.next;

        while (node.next != null) {
            node.next = dummy;
            dummy = node;
            node = ptr2;
            ptr2 = ptr2.next;
        }
        node.next = dummy;
        return node;
    }

    static ListNode reverseListRecursive(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode newHead = reverseListRecursive(node.next);
        ListNode front = node.next;
        front.next = node;
        node.next = null;
        return newHead;
    }
}
