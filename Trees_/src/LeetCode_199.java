// Right View of a Binary Tree

import java.util.*;

public class LeetCode_199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> result = topViewTraversal(root);
        System.out.println(result);
    }

    static List<Integer> rightSideViewBruteForce(TreeNode root) {
        List<List<Integer>> levelOrderList = LeetCode_102.levelOrderAnother(root);
        List<Integer> rightViewList = new ArrayList<>();

        for (int i = 0;i < levelOrderList.size();i++) {
            rightViewList.add(levelOrderList.get(i).getLast());
        }

        return rightViewList;
    }

    static List<Integer> rightSideViewOptimal(TreeNode root) {
        List<Integer> rightViewList = new ArrayList<>();
        if (root == null) return rightViewList;

        int level = 0;

        rightView(root,rightViewList,level);
        return rightViewList;
    }

    static void rightView(TreeNode root,List<Integer> list,int level) {
        if (root == null)
            return;
        if (level == list.size()) list.add(root.val);
        rightView(root.right,list,level+1);
        rightView(root.left,list,level+1);
    }

    static List<Integer> leftSideViewOptimal(TreeNode root) {
        List<Integer> leftSideViewList = new ArrayList<>();
        if (root == null) return leftSideViewList;

        int level = 0;
        leftView(root,leftSideViewList,level);
        return leftSideViewList;
    }

    static void leftView(TreeNode root,List<Integer> list, int level) {
        if (root == null) return;

        if (level == list.size()) list.add(root.val);
        leftView(root.left,list,level+1);
        leftView(root.right,list,level+1);
    }

    static List<Integer> topViewTraversal(TreeNode root) {
        ArrayList<Integer> topViewList = new ArrayList<>();
        if (root == null) return topViewList;

        Map<Integer,Integer> map = new HashMap<>();
        Queue<Map.Entry<TreeNode,Integer>> queue = new LinkedList<>();

        queue.add(new AbstractMap.SimpleEntry<>(root,0));

        while (!queue.isEmpty()) {
            Map.Entry<TreeNode,Integer> entry = queue.poll();
            TreeNode node = entry.getKey();
            int value = entry.getValue();

            if (!map.containsKey(value)) {
                map.put(value,node.val);
            }

            if (node.left != null) {
                queue.add(new AbstractMap.SimpleEntry<>(node.left,value-1));
            }

            if (node.right != null) {
                queue.add(new AbstractMap.SimpleEntry<>(node.right,value+1));
            }
        }

        for (int val: map.values()) {
            topViewList.add(val);
        }

        return topViewList;
    }
}