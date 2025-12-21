import java.util.*;


class Pair {
    TreeNode node;
    int value;

    Pair(TreeNode node,int value) {
        this.node = node;
        this.value = value;
    }
}

public class LeetCode_662 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(9);

        System.out.println(widthOfBinaryTree(root));
    }

    static int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));

        while (!q.isEmpty()) {
            int size = q.size();
            int first = 0; int last = 0;
            int min = q.peek().value;

            for (int i = 0; i < size; i++) {
                int cur_id = q.peek().value - min;
                TreeNode node = q.peek().node;
                q.poll();

                if (i == 0) first = cur_id;
                if (i == size-1) last = cur_id;

                if (node.left != null) q.add(new Pair(node.left,cur_id*2+1));
                if (node.right != null) q.add(new Pair(node.right,cur_id*2+2));
            }
            ans = Math.max(ans,last-first+1);
        }

        return ans;
    }
}
