// Maximum 69 Number

public class LeetCode_1323 {
    public static void main(String[] args) {
        int num = 9699;
        System.out.println(maximum69Number(num));
    }

    static int maximum69Number(int num) {
        String numString = Integer.toString(num);
        char[] numArray = numString.toCharArray();

        for (int i = 0;i<numArray.length;i++) {
            if (numArray[i] == '6') {
                numArray[i] = '9';
                break;
            }
        }

        return Integer.parseInt(String.valueOf(numArray));
    }
}
