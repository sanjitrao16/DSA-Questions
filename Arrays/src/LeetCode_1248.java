// Number of Nice Subarrays

import java.util.Set;
import java.util.LinkedHashSet;

import java.util.LinkedHashSet;

public class LeetCode_1248 {
    public static void main(String[] args) {
//        int[] arr = {2,4,1,2,3,1,1,2,4,6,5,3,2,1};
        int[] arr = {1,3,5,7,9,11};
        int k = 2;

        System.out.println(numberOfSubarrays(arr,k));
    }

    static int numberOfSubarrays(int[] nums,int k) {
        if (k == 0) return 0;

        int n = nums.length;
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        int l = 0;
        int r = 0;
        int count = 0;
        int oddCount = 0;

        while (r < n) {
            if (nums[r] % 2 == 0) {
                r++;
                continue;
            }

            else if (nums[r] % 2 != 0 && oddCount < k) {
                oddCount++;
                set.add(r);
            }

            if (oddCount == k) {
                int subCount = 1;
                while (r+1 < n) {
                    if (nums[r+1] % 2 == 0) {
                        r++;
                        subCount++;
                    } else {
                        break;
                    }
                }

                int index = set.removeFirst();
                int diff = index - l;
                subCount = subCount + diff*subCount;
                l = index + 1;
                count += subCount;
                oddCount--;
            }
            r++;
        }

        return count;
    }
}
