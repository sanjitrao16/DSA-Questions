// Palindrome Linked List

public class LeetCode_234 {
    public static void main(String[] args) {
        ListNode ll4 = new ListNode(1);
        ListNode ll3 = new ListNode(2,ll4);
        ListNode ll2 = new ListNode(2,ll3);
        ListNode ll1 = new ListNode(1,ll2);

        System.out.println(isPalindrome(ll1));
    }

    static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return false;

        int length = lengthOfList(head);
        int itr = length/2;

        // Find middle node of linked list
        LeetCode_876 myLL = new LeetCode_876();
        ListNode mid = myLL.middleNode(head);

        // Reverse the list from the middle node
        mid = reverseList(mid);

        // Check element val
        for (int i = 0;i<itr;i++) {
            if (head.val == mid.val) {
                head = head.next;
                mid = mid.next;
            }
            else {
                return false;
            }
        }

        return true;
    }

    static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while (curr.next != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;

        return curr;
    }

    static int lengthOfList(ListNode head) {
        int length = 1;
        while (head.next != null) {
            head = head.next;
            length++;
        }

        return length;
    }
}
