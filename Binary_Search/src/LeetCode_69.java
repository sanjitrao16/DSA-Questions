// Find the square root of a number

public class LeetCode_69 {
    public static void main(String[] args) {
        System.out.println(mySqrt(13));
        System.out.println(nthRoot(4,69));
    }

    static int mySqrt(int x) {
        if (x == 0) return 0;

        int start = 1;
        int end = x;

        while (start <= end) {
            int mid = start + (end-start)/2;
            int product = mid*mid;

            if (product == x) return mid;
            else if (product > x) end = mid-1;
            else start = mid+1;
        }

        return end;
    }

    // Finding Nth root of a number
    /*

    eg: n = 3 and m = 27
    ans = 3, since 3^3 = 27

     */
    static int nthRoot(int n,int m) {
        int start = 0;
        int end = m;

        while (start <= end) {
            int mid = start + (end-start)/2;
            int res = (int) Math.pow(n,mid);

            if (res == m) return mid;
            else if (res > m) end = mid-1;
            else start = mid+1;
        }

        return -1;
    }
}
