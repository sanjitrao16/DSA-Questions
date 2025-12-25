// Lowest Common Ancestor in BST

public class LeetCode_235 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        TreeNode result = lowestCommonAncestor(root,root.left,root.right);

        System.out.println(result.val);
    }

    /*
    *
    * If both p and q < root.val -> go left
    * If both p and q > root.val -> go right
    * If it diverges -> return root
    *
    * */

    static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right,p,q);
        }

        else return root;
    }
}
