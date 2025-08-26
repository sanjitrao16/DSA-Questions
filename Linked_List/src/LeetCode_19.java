// Remove nth node from end of list

public class LeetCode_19 {
    public static void main(String[] args) {
        ListNode ll5 = new ListNode(5);
        ListNode ll4 = new ListNode(4,ll5);
        ListNode ll3 = new ListNode(3,ll4);
        ListNode ll2 = new ListNode(2,ll3);
        ListNode ll1 = new ListNode(1,ll2);

        ListNode result = removeNthNodeFromEnd(ll1,2);
        while (result != null) {
            System.out.print(result.val+" -> ");
            result = result.next;
        }
        System.out.println("END");
    }

    static ListNode removeNthNodeFromEnd(ListNode head,int n) {
        if (n>0 && head.next == null) return null;

        ListNode temp = head, temp2 = head;
        int length = 1;

        while (true) {
            temp = temp.next;
            length++;

            if (temp.next == null) {
                if (length - n == 0) head = head.next;

                else {
                    for (int i = 0; i < length - n - 1; i++) {
                        temp2 = temp2.next;
                    }

                    temp2.next = temp2.next.next;
                    break;
                }
            }
        }

        return head;
    }
}
