// Invert Binary Tree

public class LeetCode_226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root = invertTree(root);
        System.out.println(LeetCode_102.levelOrderTraversal(root));
    }

    static TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        invert(root);
        return root;
    }

    static void invert(TreeNode root) {
        if (root.left == null && root.right == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) invert(root.left);
        if (root.right != null) invert(root.right);
    }
}
