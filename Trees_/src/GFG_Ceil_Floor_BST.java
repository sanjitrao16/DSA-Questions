// Finding Ceil and Floor in a BST

public class GFG_Ceil_Floor_BST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(8);
//        root.right = new TreeNode(7);
//
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(3);
//        root.right.right = new TreeNode(8);
//
        System.out.println(findCeil(root,9));
        System.out.println(findFloor(root,9));
    }

    static int findCeil(TreeNode root,int x) {
        if (root == null) return -1;

        if (root.val == x) return root.val;

        if (root.val < x) {
            return findCeil(root.right,x);
        }

        int ceil = findCeil(root.left,x);
        return (ceil >= x) ? ceil:root.val;
    }

    static int findFloor(TreeNode root,int x) {
        if (root == null) return -1;
        if (root.val == x) return root.val;

        if (root.val > x) {
            return findFloor(root.left,x);
        }

        int floor = findFloor(root.right,x);

        return (floor <= x && floor != -1) ? floor:root.val;
    }
}
