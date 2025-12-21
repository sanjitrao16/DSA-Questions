// Level Order Traversal

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);

        List<List<Integer>> result = levelOrderAnother(root);
        System.out.println(result);
    }

    static List<Integer> levelOrderTraversal(TreeNode root) {
        List<Integer> traversedList = new ArrayList<>();
        if (root == null) return traversedList;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = root;

        queue.add(node);

        while (!queue.isEmpty()) {
            node = queue.poll();
            traversedList.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }

        return traversedList;
    }

    static List<List<Integer>> levelOrderAnother(TreeNode root) {
        List<List<Integer>> traversedList = new ArrayList<>();
        if (root == null) return traversedList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size;
        TreeNode node = root;

        while (!queue.isEmpty()) {
            size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                node = queue.poll();
                level.add(node.val);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            traversedList.add(level);
        }

        return traversedList;
    }
}
