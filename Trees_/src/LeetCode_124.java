// Binary Tree Max Path Sum
public class LeetCode_124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

//        root.left.left = new TreeNode(-2);
//        root.left.right = new TreeNode(7);

//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

//        root.left.left.right = new TreeNode(6);
//        root.left.right.left = new TreeNode(-1);
//        root.left.right.right = new TreeNode(5);
//
//        root.right.left.right = new TreeNode(-3);
//        root.right.right.right = new TreeNode(11);

        System.out.println(maxPathSum(root));
    }

    static int maxPathSum(TreeNode root) {
        int[] res = {root.val};
        calculatePathSum(root,res);
        return res[0];
    }

    static int calculatePathSum(TreeNode root,int[] res) {
        if (root == null) return 0;

        int leftSum = Math.max(0,calculatePathSum(root.left,res));
        int rightSum = Math.max(0,calculatePathSum(root.right,res));

        res[0] = Math.max(res[0],leftSum+rightSum+root.val);

        return Math.max(leftSum,rightSum)+root.val;
    }
}
