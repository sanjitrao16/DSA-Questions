// Single Number

public class LeetCode_136 {
    public static void main(String[] args) {
        int[] arr = {2,2,1};
        System.out.println(singleNumber(arr));
    }

    static int singleNumber(int[] arr) {
        int XOR = 0;
        for (int num: arr) {
            XOR ^= num;
        }

        return XOR;
    }
}
