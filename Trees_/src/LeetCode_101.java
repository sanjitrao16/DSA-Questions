// Symmetric Tree

public class LeetCode_101 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
//
        root.left.left = new TreeNode(3);
//        root.left.right = new TreeNode(4);
//
//        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        root.left.left.right = new TreeNode(4);
        root.right.right.left = new TreeNode(4);

        System.out.println(isSymmetric(root));
    }

    static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return findSymmetric(root.left,root.right);
    }

    static boolean findSymmetric(TreeNode p,TreeNode q) {
        if (p==null && q==null) return true;
        if (p==null || q==null) return false;

        // Check values
        if (p.val != q.val) return false;

        boolean value = findSymmetric(p.left,q.right);
        if (value) {
            value = findSymmetric(p.right,q.left);
        }

        return value;
    }
}
