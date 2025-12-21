// Implement Stack using Queue

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_225 {
    public static void main(String[] args) {
        StackUsingQueue myStack = new StackUsingQueue();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        myStack.pop();
        myStack.peek();
    }
}

class StackUsingQueue {
    private Queue<Integer> queue1;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
    }

    public void push(int elem) {
        queue1.add(elem);
        System.out.println("Successful");
    }

    public void pop() {
        int n = queue1.size();

        for (int i = 0;i<n-1;i++) {
            queue1.add(queue1.poll());
        }

        System.out.println(queue1.poll());
    }

    public void peek() {
        int n = queue1.size();
        for (int i = 0;i<n-1;i++) {
            queue1.add(queue1.poll());
        }

        System.out.println(queue1.peek());
    }
}
