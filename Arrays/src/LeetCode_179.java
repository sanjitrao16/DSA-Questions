// Largest Number

public class LeetCode_179 {
    public static void main(String[] args) {
//        int[] nums = {3,30,34,5,9};
        int[] nums = {54,546,548,60};
        System.out.println(largestNumber(nums));
    }

    static String largestNumber(int[] nums) {
        // Convert each element of array to string
        int n = nums.length;
        String[] numsArray = new String[n];
        for (int i = 0;i<nums.length;i++) {
            numsArray[i] = String.valueOf(nums[i]);
        }

        // Sorting the string array
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                String comb1 = numsArray[i]+numsArray[j];
                String comb2 = numsArray[j]+numsArray[i];

                if (comb2.compareTo(comb1) > 0) {
                    String temp = numsArray[i];
                    numsArray[i] = numsArray[j];
                    numsArray[j] = temp;
                }
            }
        }

        // Traverse the array and construct the string
        if (numsArray[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String str: numsArray) {
            sb.append(str);
        }

        return sb.toString();
    }
}
