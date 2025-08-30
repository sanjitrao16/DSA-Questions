public class LeetCode_61 {
    public static void main(String[] args) {
        ListNode ll5 = new ListNode(5);
        ListNode ll4 = new ListNode(4,ll5);
        ListNode ll3 = new ListNode(3);
        ListNode ll2 = new ListNode(2,ll3);
        ListNode ll1 = new ListNode(1,ll2);

        ListNode result = rotateRight(ll1,2);

        while (result != null) {
            System.out.print(result.val+" -> ");
            result = result.next;
        }

        System.out.println("END");
    }

    static ListNode rotateRight(ListNode head,int k) {
        if (head == null || head.next == null) return head;

        int length = LeetCode_234.lengthOfList(head);
        k %= length;

        if (k==0) return head;

        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        ListNode prev = null, curr = head;
        int position = length - k;
        for (int i = 0;i<position;i++) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        last.next = head;

        head = curr;
        return head;
    }
}
