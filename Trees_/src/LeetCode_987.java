// Vertical Order Traversal
import java.util.*;

class Tuple {
    int val;
    int vd;

    public Tuple(int vd, int val) {
        this.vd = vd;
        this.val = val;
    }
}

public class LeetCode_987 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(verticalTraversal(root));
    }

    static List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> verticalList = new ArrayList<>();

        if (root == null) return null;

        Map<Integer,List<Tuple>> map = new TreeMap<>();

        verticalTraversal(root,map,0,0);

        for (List<Tuple> val: map.values()) {
            Collections.sort(val, (a, b) -> {
                if (a.vd != b.vd) {
                    return Integer.compare(a.vd, b.vd); // Sort by VD (Row)
                }
                return Integer.compare(a.val, b.val); // Sort by Value (Tie-breaker)
            });

            List<Integer> finalColumn = new ArrayList<>();
            for (Tuple data : val) {
                finalColumn.add(data.val);
            }
            verticalList.add(finalColumn);
        }

        return verticalList;
    }

    static void verticalTraversal(TreeNode root,Map<Integer,List<Tuple>> map,int hd,int vd) {
        map.putIfAbsent(hd, new ArrayList<>());
        map.get(hd).add(new Tuple(vd, root.val));

        if (root.left != null) verticalTraversal(root.left,map,hd-1,vd+1);
        if (root.right != null) verticalTraversal(root.right,map,hd+1,vd+1);
    }
}
