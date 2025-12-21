// Count Good Nodes in Binary Tree

public class LeetCode_1448 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(6);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);

        root.right.right = new TreeNode(5);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);


        System.out.println(goodNodes(root));
    }

    static int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return calculateGoodNodes(root,root.val,0);
    }

    static int calculateGoodNodes(TreeNode root,int val,int count) {
        if (root == null) return count;

        if (root.val >= val) {
            val = root.val;
            count++;
        }

        count = calculateGoodNodes(root.left,val,count);
        count = calculateGoodNodes(root.right,val,count);

        return count;
    }
}
