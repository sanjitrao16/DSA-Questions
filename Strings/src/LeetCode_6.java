// Zig-Zag conversion

public class LeetCode_6 {
    public static void main(String[] args) {
        String str = "PAYPALISHIRING";
        int rows = 4;

        System.out.println(convert(str,rows));
    }

    static String convert(String s,int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] railFence = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            railFence[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean isMovingDown = false;

        for (char c: s.toCharArray()) {
            railFence[currRow].append(c);

            if (currRow == 0 || currRow == numRows-1) {
                isMovingDown = !isMovingDown;
            }

            currRow += isMovingDown ? 1:-1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row: railFence) {
            result.append(row);
        }

        return result.toString();
    }
}
