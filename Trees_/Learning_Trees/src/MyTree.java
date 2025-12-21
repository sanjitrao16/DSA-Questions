public class MyTree {
    static class Node {
        Node left;
        int val;
        Node right;

        Node(int val) {
            this.val = val;
        }

        Node(int val,Node left,Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
    }
}
