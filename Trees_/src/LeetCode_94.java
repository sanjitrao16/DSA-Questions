// In-Order Binary Tree Traversal

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class LeetCode_94 {
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

        List<Integer> result = inorderTraversalIterative(root);
        System.out.println(result);
    }

    /*
     * In-Order Traversal: Left -> Root -> Right
     *
     *
     */

    static List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> traversedList = new ArrayList<>();

        if (root == null) return traversedList;

        return inorderTraverse(root,traversedList);
    }
    // Time Complexity -> O(N) , Space Complexity -> O(N)

    private static List<Integer> inorderTraverse(TreeNode root,List<Integer> traversedList) {
        if (root == null) return null;

        inorderTraverse(root.left,traversedList);
        traversedList.add(root.val);
        inorderTraverse(root.right,traversedList);

        return traversedList;
    }

    static List<Integer> inorderTraversalIterative(TreeNode root) {
        List<Integer> traversedList = new ArrayList<>();
        if (root == null) return traversedList;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        stack.add(node);
        node = node.left;

        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
                traversedList.add(node.val);
                node = node.right;
            }
            if (node != null) {
                stack.add(node);
                node = node.left;
            }
        }

        return traversedList;
    }
}
