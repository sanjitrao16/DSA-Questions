// Merge k Sorted Lists

import java.util.Collections;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {this.val = val;}
    ListNode(int val,ListNode next) {this.val = val; this.next = next;}
}
public class LeetCode_23 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(4,l1);
        ListNode head1 = new ListNode(1,l2);


        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3,l3);
        ListNode head2 = new ListNode(1,l4);

        ListNode l5 = new ListNode(6);
        ListNode head3 = new ListNode(2,l5);

        ListNode[] lists = {head1,head2,head3};
//        ListNode[] lists = {null,null};
        ListNode node = mergeKListsOptimal(lists);

        while (node != null) {
            System.out.print(node.val+"->");
            node = node.next;
        }
        System.out.println("NULL");
    }

    static ListNode mergeKListsOptimal(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);

        for (ListNode node: lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode ptr = null;
        ListNode head = null;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            if (node.next != null) pq.add(node.next);

            if (head == null) {
                head = node;
                ptr = head;
            } else {
                ptr.next = node;
                ptr = node;
            }
        }

        return head;
    }

    static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0;i<lists.length;i++) {
            ListNode ptr = lists[i];

            while (ptr != null) {
                pq.add(ptr.val);
                ptr = ptr.next;
            }
        }

        ListNode prev = null;
        ListNode curr = null;

        while (!pq.isEmpty()) {
            if (prev == null && curr == null) {
                curr = new ListNode(pq.poll());
                prev = curr;
            } else {
                curr = new ListNode(pq.poll());
                curr.next = prev;
                prev = curr;
            }
        }

        return curr;
    }
}
