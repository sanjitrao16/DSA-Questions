public class StacksUsingArrays {
    public static void main(String[] args) {
        MyStack mystack = new MyStack(5);
        System.out.println(mystack.pushElement(1));
        System.out.println(mystack.pushElement(2));
        System.out.println(mystack.pushElement(3));
        System.out.println(mystack.pushElement(4));
        System.out.println(mystack.pushElement(5));
        mystack.displayStack();

        System.out.println(mystack.popElement());
        mystack.displayStack();
        System.out.println(mystack.pushElement(7));
        mystack.displayStack();
    }
}

class MyStack {
    private int size;
    private int top = -1;
    private int[] arr;
    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public int pushElement(int elem) {
        top++;
        if (top == size) {
            top--;
            return -1;
        }
        arr[top] = elem;
        return top;
    }

    public int popElement() {
        int elem = arr[top];
        top--;
        return elem;
    }

    public int peekElement() {
        if (top == -1) return -1;
        return arr[top];
    }

    public void displayStack() {
        System.out.print("[");
        for (int i = 0;i <= top;i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println("]");
    }
}
