// Post-Order Binary Tree Traversal

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_145 {
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

        List<Integer> result = postorderTraversalIterativeOneStack(root);
        System.out.println(result);
    }

    static List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> traversedList = new ArrayList<>();
        if (root == null) return traversedList;
        return postorderTraverse(root,traversedList);
    }

    static List<Integer> postorderTraverse(TreeNode root,List<Integer> traversedList) {
        if (root == null) return null;

        postorderTraverse(root.left,traversedList);
        postorderTraverse(root.right,traversedList);
        traversedList.add(root.val);

        return traversedList;
    }

    static List<Integer> postorderTraversalIterativeOneStack(TreeNode root) {
        List<Integer> traversedList = new ArrayList<>();
        if (root == null) return traversedList;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode temp;

        while (!stack.isEmpty() || node != null) {
            if (node != null) {
                stack.add(node);
                node = node.left;
            }
            else {
                temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    traversedList.add(temp.val);

                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        traversedList.add(temp.val);
                    }
                } else {
                    node = temp;
                }
            }
        }

        return traversedList;
    }

    static List<Integer> postorderTraversalIterativeTwoStack(TreeNode root) {
        List<Integer> traversedList = new ArrayList<>();
        if (root == null) return traversedList;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode node = root;

        stack1.add(node);

        while (!stack1.isEmpty()) {
            node = stack1.pop();
            stack2.add(node);

            if (node.left != null) stack1.add(node.left);
            if (node.right != null) stack1.add(node.right);

            node = stack2.peek();
        }

        while (!stack2.isEmpty()) {
            traversedList.add(stack2.pop().val);
        }

        return traversedList;
    }
}
