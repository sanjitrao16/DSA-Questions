// Diameter of a Binary Tree

public class LeetCode_543 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);

//        root.left.left.left = new TreeNode(5);
//        root.left.left.left.right = new TreeNode(6);
//
//        root.left.right.left = new TreeNode(8);
//        root.left.right.right = new TreeNode(10);
//        root.left.right.left.right = new TreeNode(9);

        System.out.println(diameterOfBinaryTree(root));
    }

    static int diameterOfBinaryTree(TreeNode root) {
        int[] result = findDiameter(root);
        return result[1];
    }

    static int[] findDiameter(TreeNode root) {
        // Array of two element
        /* [depth,diameter] */
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftArray = findDiameter(root.left);
        int[] rightArray = findDiameter(root.right);

        int leftDepth = leftArray[0];
        int rightDepth = rightArray[0];
        int diameter = leftDepth + rightDepth;
        int maxDiameter = Math.max(leftArray[1],rightArray[1]);

        return new int[] {Math.max(leftDepth,rightDepth)+1,Math.max(diameter,maxDiameter)};
    }
}
