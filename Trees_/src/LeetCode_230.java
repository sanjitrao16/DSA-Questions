// Kth Smallest Element in BST

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode_230 {
    int kSmallest;
    int count;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        LeetCode_230 obj = new LeetCode_230();
        System.out.println(obj.kthSmallestOptimal(root,3));
    }
    // Brute-Force Approach
    // Follow in-order traversal, because it returns in sorted order and then find the kth element.
    static int kthSmallest(TreeNode root,int k) {
        List<Integer> result = LeetCode_94.inorderTraversalIterative(root);
        return result.get(k-1);
    }

    // Optimal Approach
    static int kthSmallestBetter(TreeNode root,int k) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        stack.add(node);

        node = node.left;
        int size;
        while (!stack.isEmpty() || node != null) {
            size = list.size();
            if (size == k) break;

            if (node == null) {
                node = stack.pop();
                list.add(node.val);
                node = node.right;
            }
            if (node != null) {
                stack.add(node);
                node = node.left;
            }
        }

        return list.getLast();
    }

    public int kthSmallestOptimal(TreeNode root, int k) {
        count = k;
        preOrder(root);

        return kSmallest;
    }

    private void preOrder(TreeNode root) {
        if (root == null) return;

        preOrder(root.left);
        count--;

        if (count == 0) kSmallest = root.val;
        preOrder(root.right);
    }
}
