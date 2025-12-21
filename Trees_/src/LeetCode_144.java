// Pre-Order Binary Tree Traversal

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_144 {
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

        List<Integer> result = preOrderTraversalIterative(root);
        System.out.println(result);
    }

    /*
    * Pre-Order Traversal: Root -> Left -> Right
    *
    *
    */
    static List<Integer> preOrderTraversalRecursive(TreeNode root) {
        List<Integer> traversedList = new ArrayList<>();
        if (root == null) return traversedList;
        return preorderTraverse(traversedList,root);
    }
    // Time Complexity -> O(N) , Space Complexity -> O(N)

    static List<Integer> preorderTraverse(List<Integer> traversedList,TreeNode root) {
        if (root == null) {
            return null;
        }
        traversedList.add(root.val);
        preorderTraverse(traversedList,root.left);
        preorderTraverse(traversedList,root.right);

        return traversedList;
    }

    static List<Integer> preOrderTraversalIterative(TreeNode root) {
        List<Integer> traversedList = new ArrayList<>();

        if (root == null) return traversedList;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        traversedList.add(node.val);
        if (node.right != null) stack.add(node.right);
        node = node.left;

        while (!stack.isEmpty() || node != null) {
            if (node == null) {
                node = stack.pop();
            }
            traversedList.add(node.val);
            if (node.right != null) stack.add(node.right);
            node = node.left;
        }

        return traversedList;
    }
}
