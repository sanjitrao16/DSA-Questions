// Predecessor and Successor in BST

import java.util.ArrayList;

public class GFG_Pred_Succ_BST {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(8);
//        root.left = new TreeNode(1);
//        root.right = new TreeNode(9);
//
////        root.left.left = new TreeNode(20);
//        root.left.right = new TreeNode(4);
//
//        root.left.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(10);

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ArrayList<TreeNode> result = findPreSuc(root,3);
        System.out.println("Predecessor: "+result.get(0).val);
        System.out.println("Successor: "+result.get(1).val);
    }
    // Brute-Force Approach -> Find the inorder traversal and iterate through it to get the predecessor and successor

    static ArrayList<TreeNode> findPreSuc(TreeNode root,int key) {
        TreeNode min = null;
        TreeNode max = null;

        while (root != null) {
            if (key > root.val) {
                if (min == null || root.val > min.val) {
                    min = root;
                }
                root = root.right;
            }

            else if (key < root.val) {
                if (max == null || root.val < max.val) {
                    max = root;
                }
                root = root.left;
            }

            else {
                if (root.left != null) min = findMax(root.left);
                if (root.right != null) max = findMin(root.right);
                break;
            }
        }

        ArrayList<TreeNode> range = new ArrayList<>(2);
        if (min == null) range.add(new TreeNode(-1));
        else range.add(min);

        if (max == null) range.add(new TreeNode(-1));
        else range.add(max);

        return range;
    }

    static TreeNode findMax(TreeNode root) {
        while (root.right != null) root = root.right;
        return root;
    }

    static TreeNode findMin(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }
}
