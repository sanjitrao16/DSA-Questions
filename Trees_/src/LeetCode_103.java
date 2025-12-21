// Binary Tree Zig-Zag Traversal

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class LeetCode_103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left.left.right = new TreeNode(8);
        root.right.left.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);
        System.out.println(result);
    }

    static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversedList = new ArrayList<>();

        if (root == null) return traversedList;

        Stack<TreeNode> evenStack = new Stack<>();
        Stack<TreeNode> oddStack = new Stack<>();

        int levelCount = 0;
        int size;
        TreeNode node = root;
        evenStack.add(node);

        while (!evenStack.isEmpty() || !oddStack.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            if (levelCount % 2 == 0) {
                size = evenStack.size();

                for (int i = 0; i < size; i++) {
                    node = evenStack.pop();
                    level.add(node.val);

                    if (node.left != null) oddStack.add(node.left);
                    if (node.right != null) oddStack.add(node.right);
                }
            }

            else {
                size = oddStack.size();

                for (int i = 0; i < size; i++) {
                    node = oddStack.pop();
                    level.add(node.val);

                    if (node.right != null) evenStack.add(node.right);
                    if (node.left != null) evenStack.add(node.left);
                }
            }

            levelCount++;
            traversedList.add(level);
        }

        return traversedList;
    }
}
