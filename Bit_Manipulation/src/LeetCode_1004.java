// Max Consecutive Ones III

import java.util.LinkedHashSet;

public class LeetCode_1004 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
//        int[] nums = {1,0,1,1,0,0};
//        int[] nums = {1,0,0,0,0,0};
        int k = 1;
        System.out.println(longestOnes(nums,k));
    }

    static int longestOnes(int[] nums,int k) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeroCount  = 0;

        while (r < nums.length) {
            if (nums[r] == 1) {
                maxLen = Math.max(maxLen,r-l+1);
                r++;
            }
            else {
                if (k == 0) {
                    r++;
                    l = r;
                    continue;
                }
                if (zeroCount < k) {
                    zeroCount++;
                } else {
                    l = set.removeFirst()+1;
                }
                set.add(r);
                maxLen = Math.max(maxLen,r-l+1);
                r++;
            }
        }
        return maxLen;
    }
}
