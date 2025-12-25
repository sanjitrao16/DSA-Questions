// Validate BST

public class LeetCode_98 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(15);
        root.left = new TreeNode(10);
        root.right = new TreeNode(25);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(14);

        root.right.left = new TreeNode(19);
        root.right.right = new TreeNode(36);

        root.right.left.right = new TreeNode(23);

        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(9);

        root.left.left.right.left = new TreeNode(7);

        System.out.println(isValidBST(root));
        System.out.println(Integer.MIN_VALUE);
    }

    static boolean isValidBST(TreeNode root) {
        return isValid(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    static boolean isValid(TreeNode root,int min,int max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
    }
}
