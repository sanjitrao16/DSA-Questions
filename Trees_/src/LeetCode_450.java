// Deleting a node in BST

public class LeetCode_450 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(7);

        TreeNode result = deleteNode(root,3);

        System.out.println(LeetCode_94.inorderTraversalRecursive(result));
    }

    /*

    * 1. Search for the node.
    * 2. Delete the node
    * 3. Rearrange the tree (right subtree to the rightmost node of the left subtree)
    *
    * */
    static TreeNode deleteNode(TreeNode root,int key) {
        if (root == null) return root;
        if (root.val == key) return helper(root);

        TreeNode dummy = root;
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            }
            else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

        return dummy;
    }

    static TreeNode helper(TreeNode root) {
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        TreeNode rightChild = root.right;
        TreeNode lastRight = findLastRight(root.left);
        lastRight.right = rightChild;

        return root.left;
    }

    static TreeNode findLastRight(TreeNode root) {
        if (root.right == null) return root;
        return findLastRight(root.right);
    }
}
