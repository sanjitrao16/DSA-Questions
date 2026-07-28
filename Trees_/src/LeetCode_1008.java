// Construct Binary Search Tree from Pre-order Traversal

public class LeetCode_1008 {
    private int i = 0;
    public static void main(String[] args) {
        int[] preorder = {1,3};

        TreeNode root = bstFromPreorder(preorder);

        System.out.println(LeetCode_102.levelOrderTraversal(root));
    }

    static TreeNode bstFromPreorder(int[] preorder) {
        LeetCode_1008 obj = new LeetCode_1008();
        return obj.constructTree(preorder,Integer.MAX_VALUE);
    }

    private TreeNode constructTree(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i++]);
        root.left = constructTree(preorder,root.val);
        root.right = constructTree(preorder,bound);

        return root;
    }
}
