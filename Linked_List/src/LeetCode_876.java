// Middle of a Linked List

public class LeetCode_876 {
    public static void main(String[] args) {
        ListNode ll6 = new ListNode(6);
        ListNode ll5 = new ListNode(5,ll6);
        ListNode ll4 = new ListNode(4,ll5);
        ListNode ll3 = new ListNode(3,ll4);
        ListNode ll2 = new ListNode(2,ll3);
        ListNode ll1 = new ListNode(1,ll2);

        System.out.println(middleNode(ll1).val);
    }

    static ListNode middleNode(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
