// Search in Binary Search Tree

public class LeetCode_700 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        TreeNode result = searchBST(root,9);
        if (result == null) System.out.println("NULL");
        else System.out.println(result.val);
    }
    static TreeNode searchBST(TreeNode root,int val) {
        if (root == null) return root;
        if (root.val == val) return root;
        TreeNode node;
        if (root.val < val) {
            node = searchBST(root.right,val);
        }
        else node = searchBST(root.left,val);

        return node;
    }
}
