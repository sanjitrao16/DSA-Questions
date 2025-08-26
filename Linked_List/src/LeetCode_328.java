// Odd Even Linked List

public class LeetCode_328 {
    public static void main(String[] args) {
        ListNode ll7 = new ListNode(7);
        ListNode ll6 = new ListNode(4,ll7);
        ListNode ll5 = new ListNode(6,ll6);
        ListNode ll4 = new ListNode(5,ll5);
        ListNode ll3 = new ListNode(3,ll4);
        ListNode ll2 = new ListNode(1,ll3);
        ListNode ll1 = new ListNode(2,ll2);

        ListNode result = oddEvenList(ll1);

        // Display list

        while (result != null) {
            System.out.print(result.val+" -> ");
            result = result.next;
        }
        System.out.println("END");
    }

    static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;

        ListNode oddNode = head;
        ListNode evenHead = head.next;
        ListNode evenNode = head.next;

        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = evenHead;

        return head;
    }
}
