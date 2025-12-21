// Same Tree

public class LeetCode_100 {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println(isSameTree(root1,root2));
    }

    static boolean isSameTree(TreeNode p,TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;

        boolean leftResult = isSameTree(p.left,q.left);
        boolean rightResult = isSameTree(p.right,q.right);

        return leftResult && rightResult;
    }
}
