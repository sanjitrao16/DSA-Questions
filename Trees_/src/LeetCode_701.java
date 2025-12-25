// Insert into BST

public class LeetCode_701 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = insertIntoBST(root,5);

        System.out.println(LeetCode_94.inorderTraversalRecursive(result));
    }

    static TreeNode insertIntoBST(TreeNode root,int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = root;
        TreeNode prevNode = null;
        boolean isLeft = false;

        while (node != null) {
            if (node.val < val) {
                prevNode = node;
                node = node.right;
                isLeft = false;
            }
            else {
                prevNode = node;
                node = node.left;
                isLeft = true;
            }
        }

        if (isLeft) prevNode.left = new TreeNode(val);
        else prevNode.right = new TreeNode(val);

        return root;
    }
}
