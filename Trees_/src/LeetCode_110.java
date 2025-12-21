// Balanced Binary Tree

public class LeetCode_110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);


        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left.left.left = new TreeNode(9);
        root.left.left.right = new TreeNode(10);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        root.left.left.right.left = new TreeNode(11);

        root.left.left.right.left.left = new TreeNode(12);
        System.out.println(isBalanced(root));
    }

    static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        int leftDepth = checkBalanced(root.left);
        if (leftDepth == -1) return false;
        int rightDepth = checkBalanced(root.right);
        if (rightDepth == -1) return false;

        int difference = Math.abs(leftDepth-rightDepth);
        return difference <= 1;
    }

    static int checkBalanced(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = checkBalanced(root.left);
        if (leftDepth == -1) return -1;
        int rightDepth = checkBalanced(root.right);
        if (rightDepth == -1) return -1;

        int difference = Math.abs(leftDepth-rightDepth);

        if (difference <= 1) return Math.max(leftDepth,rightDepth)+1;
        return -1;
    }
}
