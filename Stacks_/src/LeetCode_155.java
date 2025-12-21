import java.util.Stack;

public class LeetCode_155 {
    public static void main(String[] args) {
        MinStack myMinStack = new MinStack();
        myMinStack.push(6);
        myMinStack.push(8);
        myMinStack.push(7);
        myMinStack.push(5);
        myMinStack.push(8);
        myMinStack.push(6);
        myMinStack.push(4);
        myMinStack.pop();
        myMinStack.pop();
        myMinStack.pop();
//        myMinStack.pop();
//        myMinStack.pop();
//        myMinStack.pop();
//        myMinStack.pop();

        System.out.println("MIN VALUE in STACK: "+myMinStack.getMin());
    }
}

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    private int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (val <= min) {
            min = val;
            minStack.push(min);
        }
        System.out.println("Element is pushed into the stack.");
    }

    public void pop() {
        int val = stack.pop();
        if (val == min) {
            minStack.pop();
            if (!minStack.isEmpty()) min = minStack.peek();
            else min = Integer.MAX_VALUE;
        }
        System.out.println("Element popped is: "+val);
    }

    public void top() {
        int val = stack.peek();
        System.out.println("Top Element in the stack is: "+val);
    }

    public int getMin() {
        return min;
    }
}
