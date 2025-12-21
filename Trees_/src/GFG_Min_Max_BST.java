// Finding minimum and maximum in BST

public class GFG_Min_Max_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(1);

        System.out.println("Minimum Element: "+minOfBST(root));
        System.out.println("Maximum Element: "+maxOfBST(root));
    }

    static int minOfBST(TreeNode root) {
        // Traverse as left as possible until the node has no left children
        if (root.left == null) return root.val;

        return minOfBST(root.left);
    }

    static int maxOfBST(TreeNode root) {
        if (root.right == null) return root.val;

        return maxOfBST(root.right);
    }
}
