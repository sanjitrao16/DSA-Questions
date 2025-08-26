// Find intersection of two Linked Lists

public class LeetCode_160 {
    public static void main(String[] args) {
        // List A
        ListNode ll5 = new ListNode(5);
        ListNode ll4 = new ListNode(4,ll5);
        ListNode ll3 = new ListNode(8,ll4);
        ListNode ll2 = new ListNode(1,ll3);
        ListNode ll1 = new ListNode(4,ll2);

        // List B
        ListNode ll6 = new ListNode(1,ll3);
        ListNode ll7 = new ListNode(6,ll6);
        ListNode ll8 = new ListNode(5,ll7);

        ListNode result = getIntersectionNode(ll1,ll8);

        System.out.println(result.val);
    }

    static ListNode getIntersectionNode(ListNode headA,ListNode headB) {
        int lengthA = 1;
        int lengthB = 1;
        ListNode tempA = headA, tempB = headB;

        while (tempA != null) {
            tempA = tempA.next;
            lengthA++;
        }

        while (tempB != null) {
            tempB = tempB.next;
            lengthB++;
        }

        while (lengthA>lengthB) {
            lengthA--;
            headA = headA.next;
        }

        while (lengthB>lengthA) {
            lengthB--;
            headB = headB.next;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;
    }
}
