// Assign Cookies

import java.util.Arrays;
import java.util.Collections;

public class LeetCode_255 {
    public static void main(String[] args) {
        int[] greedArray = {1,2};
        int[] sizeArray = {};

        System.out.println(findContentChildren(greedArray,sizeArray));
    }

    static int findContentChildren(int[] g,int[] s) {
        if (s.length == 0) return 0;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int maxContentChildren = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                maxContentChildren++;
                i++;
                j++;
            }
            else {
                j++;
            }
        }

        return maxContentChildren;
    }
}
