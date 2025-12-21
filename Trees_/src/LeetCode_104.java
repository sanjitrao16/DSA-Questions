// Maximum Depth of a Binary Tree

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(4);

        root.left.left.left = new TreeNode(10);
        root.left.right.left = new TreeNode(11);
        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(6);

        root.left.right.left.left = new TreeNode(12);
        root.left.right.left.right = new TreeNode(13);

        root.right.left.right.right = new TreeNode(7);

        int result = maxDepthRecursive(root);
        System.out.println(result);
    }

    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int maxDepth = 1;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;
        queue.add(node);
        int size;

        while (!queue.isEmpty()) {
            size = queue.size();

            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (!queue.isEmpty()) maxDepth++;
        }
        return maxDepth;
    }

    static int maxDepthRecursive(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepthRecursive(root.left);
        int rightDepth = maxDepthRecursive(root.right);

        return 1+Math.max(leftDepth,rightDepth);
    }
}
