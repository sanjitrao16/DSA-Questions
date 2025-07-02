// Single Number

public class LeetCode_136 {
    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};

        System.out.println(singleNumber(arr));
    }

    static int singleNumber(int[] nums) {
        int XOR = 0;

        for (int elem: nums) {
            XOR ^= elem;
        }

        return XOR;
    }
}
