// Construct a BST from preorder and inorder traversal

import java.util.HashMap;
import java.util.Map;
public class LeetCode_105 {
    public static void main(String[] args) {
        int[] preOrder = {2,4,5,1,6,3,7,8,12,9,14,10,16};
        int[] inOrder = {1,5,4,3,6,7,2,12,9,8,10,14,16};

        TreeNode root = buildTree(preOrder,inOrder);
        System.out.println(LeetCode_144.preOrderTraversalIterative(root));
    }

    static TreeNode buildTree(int[] preorder,int[] inorder) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        for (int i = 0;i<inorder.length;i++) {
            map.put(inorder[i],i);
        }

        return buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }

    static TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,Map<Integer,Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);

        int index = map.get(root.val);
        int leftSubTreeLength = index - inStart;

        root.left = buildTree(preorder,preStart + 1,preStart + leftSubTreeLength,inorder,inStart,index-1,map);
        root.right = buildTree(preorder,preStart+leftSubTreeLength+1,preEnd,inorder,index+1,inEnd,map);

        return root;
    }
}
