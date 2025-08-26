// Delete the middle of a Linked List

public class LeetCode_2095 {
    public static void main(String[] args) {
        ListNode ll7 = new ListNode(6);
        ListNode ll6 = new ListNode(2,ll7);
        ListNode ll5 = new ListNode(1,ll6);
        ListNode ll4 = new ListNode(4,ll5);
        ListNode ll3 = new ListNode(3,ll4);
        ListNode ll2 = new ListNode(2,ll3);
        ListNode ll1 = new ListNode(1,ll2);

        ListNode result = deleteMiddle(ll1);
        while (result != null) {
            System.out.print(result.val+" -> ");
            result = result.next;
        }
        System.out.println("END");
    }

    static ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;

        ListNode fast = head,slow = head, temp = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            temp = slow;
            slow = slow.next;
        }

        temp.next = slow.next;
        return head;
    }
}
