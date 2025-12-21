// Implement Queue using Stack

import java.util.Stack;

public class LeetCode_232 {
    public static void main(String[] args) {
        myQueue queue = new myQueue();

        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop();
        queue.peek();
        queue.push(4);
        queue.push(5);
        queue.pop();
        queue.peek();
    }
}

class myQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public myQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public void pop() {
        if (s1.isEmpty()) System.out.println("Queue is empty");

        int n = s1.size();
        // Transfer elements from s1 to s2
        for (int i = 0;i<n;i++) {
            int elem = s1.pop();
            s2.push(elem);
        }

        // Pop the element from s2
        int removed = s2.pop();

        // Update the original stack by transferring elements from s2 to s1
        n = s2.size();
        s1.empty();
        for (int i = 0;i<n;i++) {
            int elem = s2.pop();
            s1.push(elem);
        }

        System.out.println("The removed element is: "+removed);
    }

    public void peek() {
        if (s1.isEmpty()) System.out.println("Queue is empty");

        int n = s1.size();
        // Transfer elements from s1 to s2
        for (int i = 0;i<n;i++) {
            int elem = s1.pop();
            s2.push(elem);
        }

        // Pop the element from s2
        int topElement = s2.peek();

        // Update the original stack by transferring elements from s2 to s1
        n = s2.size();
        for (int i = 0;i<n;i++) {
            int elem = s2.pop();
            s1.push(elem);
        }

        System.out.println("The top element is: "+topElement);
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
