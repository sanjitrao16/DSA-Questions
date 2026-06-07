// Valid Mountain Array

public class LeetCode_941 {
    public static void main(String[] args) {
        int[] mountain = {0,2,3,4,5,2,1,0};

        System.out.println(isValidMountainArray(mountain));
    }

    static boolean isValidMountainArray(int[] arr) {
        if (arr.length < 3) return false;
        int left = 0;
        int right = arr.length-1;

        while (left + 1 < arr.length - 1 && arr[left] < arr[left+1]) left++;
        while (right - 1 > 0 && arr[right] < arr[right-1]) right--;

        return (left == right);
    }
}
