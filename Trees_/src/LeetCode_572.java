// Sub Tree of a Binary Tree
public class LeetCode_572 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(2);

        TreeNode subroot = new TreeNode(4);
        subroot.left = new TreeNode(1);
        subroot.right = new TreeNode(2);

        System.out.println(isSubtreeOptimal(root,subroot));
    }

    static boolean isSubTree(TreeNode root,TreeNode subroot) {
        if (root == null && subroot == null) return true;
        if (root == null || subroot == null) return false;

        if (root.val == subroot.val) {
            boolean result = sameTree(root,subroot);
            if (result) return result;
        }

        boolean leftResult = isSubTree(root.left,subroot);
        if (leftResult) return leftResult;
        boolean rightResult = isSubTree(root.right,subroot);

        return rightResult;

    }

    static boolean sameTree(TreeNode p,TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        boolean leftResult = sameTree(p.left,q.left);
        boolean rightResult = sameTree(p.right,q.right);

        return leftResult && rightResult;
    }

    static boolean isSubtreeOptimal(TreeNode root,TreeNode subroot) {
        if (root == null) return false;

        if (sameTree(root,subroot)) return true;

        return isSubtreeOptimal(root.left,subroot) || isSubtreeOptimal(root.right,subroot);
    }
}
