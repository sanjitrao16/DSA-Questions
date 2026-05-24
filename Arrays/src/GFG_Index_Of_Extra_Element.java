/*
You have given two sorted arrays a[] & b[] of distinct elements. The first array has one element extra added in between. Return the index of the extra element.

Note: 0-based indexing is followed.
 */

public class GFG_Index_Of_Extra_Element {
    public static void main(String[] args) {
        int[] a = {3,5};
        int[] b = {3};

        System.out.println(findExtra(a,b));
    }

    static int findExtra(int[] a,int[] b) {
        int n = a.length;
        int m = b.length;

        int index = 0;

        while (index < m) {
            if ((a[index] ^ b[index]) != 0) return index;
            index++;
        }
        return n-1;
    }
}
