public class QueueUsingArray {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.peek();
        queue.dequeue();
        queue.displayQueue();
    }
}

class MyQueue {
    private int size;
    private int start = -1;
    private int end = -1;
    private int[] queue;

    public MyQueue(int size) {
        this.size = size;
        queue = new int[size];
    }

    public void enqueue(int elem) {
        if (end >= size-1) {
            System.out.println("Queue is full");
            return;
        }

        if (start == -1) start = 0;

        end++;
        queue[end] = elem;
        System.out.println("Successful");
    }

    public void peek() {
        if (end == -1) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.println(queue[end]);
    }

    public void dequeue() {
        if (start == -1) {
            System.out.println("Queue is empty");
        }
        System.out.println(queue[start]);
        start++;
    }

    public void displayQueue() {
        if (start == -1) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("[");
        for (int i = start;i<=end;i++) {
            System.out.print(queue[i]+",");
        }
        System.out.println("]");
    }
}
