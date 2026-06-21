// Kth-largest element in an array

import java.util.PriorityQueue;
public class LeetCode_215 {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int k = 3;

        System.out.println(findKthLargest(arr,k));
    }

    static int findKthLargest(int[] arr,int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int val: arr) {
            minHeap.add(val);

            if (minHeap.size() > k) minHeap.poll();
        }

        return minHeap.peek();
    }
}
