// Detect a loop

import java.util.List;

public class LeetCode_141 {
    public static void main(String[] args) {
        ListNode ll4 = new ListNode(-4);
        ListNode ll3 = new ListNode(0,ll4);
        ListNode ll2 = new ListNode(2,ll3);
        ListNode ll1 = new ListNode(3,ll2);

        ll4.next = ll2;

        System.out.println(hasCycle(ll1));
    }

    static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }

        return false;
    }
}
