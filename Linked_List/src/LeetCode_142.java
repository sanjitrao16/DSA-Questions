// Find Starting point in a linked list loop

public class LeetCode_142 {
    public static void main(String[] args) {
        ListNode ll4 = new ListNode(-4);
        ListNode ll3 = new ListNode(0,ll4);
        ListNode ll2 = new ListNode(2,ll3);
        ListNode ll1 = new ListNode(3,ll2);

        ll4.next = ll2;

        ListNode result = detectCycle(ll1);
        System.out.println(result.val);
    }

    static ListNode detectCycle(ListNode head) {
        int length = lengthOfCycle(head);

        if (length == 0) return null;

        ListNode fast = head, slow = head;

        for (int i = 0;i<length;i++) {
            slow = slow.next;
        }

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    static int lengthOfCycle(ListNode head) {
        if (head == null || head.next == null) return 0;

        int length = 1;
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                slow = slow.next;
                while (fast != slow) {
                    slow = slow.next;
                    length++;
                }
                return length;
            }
        }

        return 0;
    }
}
