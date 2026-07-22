// BST to Greater Sum Tree

import org.w3c.dom.Node;

import java.util.List;

public class LeetCode_1038 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        LeetCode_102 obj = new LeetCode_102();
        List<List<Integer>> list = obj.levelOrderAnother(bstToGst(root));
        System.out.println(list);
    }

    static TreeNode bstToGst(TreeNode root) {
        int val = GST(root,0);
        return root;
    }

    static int GST(TreeNode root,int sum) {
        if (root == null) return sum;

        root.val = root.val + GST(root.right,sum);
        sum = GST(root.left,root.val);
        return Math.max(sum,root.val);
    }
}
