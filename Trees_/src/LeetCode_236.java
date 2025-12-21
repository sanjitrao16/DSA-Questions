// Lowest Common Ancestor

import java.util.ArrayList;
import java.util.List;

public class LeetCode_236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);

        System.out.println(leastCommonAncestorOptimal(root,root.left,root.left.right.left).val);
    }

    static TreeNode lowestCommonAncestorBF(TreeNode root,TreeNode p,TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();

        findPath(root,p,list1);
        findPath(root,q,list2);

        int n = Math.min(list1.size(),list2.size());
        TreeNode node = root;
        for (int i = 0; i < n; i++) {
            if (list1.get(i).val == list2.get(i).val) {
                node = list1.get(i);
            }
            else {
                break;
            }
        }

        return node;
    }

    static void findPath(TreeNode root,TreeNode p,List<TreeNode> list) {
        boolean result = helperFunction(root,p,list);
    }

    static boolean helperFunction(TreeNode root,TreeNode node,List<TreeNode> list) {
        if (root == null) return false;
        if (root.val == node.val) {
            list.add(root);
            return true;
        }
        list.add(root);
        boolean leftResult = helperFunction(root.left,node,list);
        if (leftResult) return true;
        boolean rightResult = helperFunction(root.right,node,list);

        if (!(leftResult || rightResult)) {
            list.removeLast();
            return false;
        }
        else return true;
    }

    static TreeNode leastCommonAncestorOptimal(TreeNode root,TreeNode p,TreeNode q) {
        if (root == null || root == p || root == q) return root;

        TreeNode nodeLeft = leastCommonAncestorOptimal(root.left,p,q);
        TreeNode nodeRight = leastCommonAncestorOptimal(root.right,p,q);

        if (nodeLeft == null) return nodeRight;
        else if (nodeRight == null) return nodeLeft;
        else return root;
    }
}
