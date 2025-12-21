import java.util.Arrays;
import java.util.ArrayList;

public class MyHeap {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(9);
        arr.add(5);
        arr.add(8);
        arr.add(10);
        arr.add(6);
        arr.add(7);
        arr.add(4);
        System.out.println(arr);
        /*
        Original representation

              9
           5     8 -> index
        10   6 7   4

         */

        /*
        Expected representation

            4
         5     7
      10   6 9   8

         */

        minHeapify(arr,arr.size());
        System.out.println("Minimum Element: "+arr.getFirst());
        System.out.println(arr);

        // Inserting element
        insertElement(arr,3);
        System.out.println("Minimum Element: "+arr.getFirst());
        System.out.println(arr);

        // Removing element
        removeElement(arr,2);
        System.out.println("Element at removed index is (2): "+arr.get(2));
        System.out.println(arr);
    }

    static void minHeapify(ArrayList<Integer> arr,int n) {
        int lastNonLeafNode = n/2 - 1;

        for (int i = lastNonLeafNode;i>=0;i--) {
            heapify(arr,i,n);
        }
    }

    static void heapify(ArrayList<Integer> arr,int index,int n) {
        int smallest = index;
        int left = 2*index+1;
        int right = 2*index+2;

        if (left < n && arr.get(left) < arr.get(smallest)) {
            smallest = left;
        }

        if (right < n && arr.get(right) < arr.get(smallest)) {
            smallest = right;
        }

        if (smallest != index) {
            swapElements(arr,smallest,index);
            heapify(arr,smallest,n);
        }
    }

    static void swapElements(ArrayList<Integer> arr,int n1,int n2) {
        int temp = arr.get(n1);
        arr.set(n1,arr.get(n2));
        arr.set(n2,temp);
    }

    static void insertElement(ArrayList<Integer> arr,int elem) {
        arr.add(elem);
        int index = arr.indexOf(elem);
        upHeap(arr,index);
    }

    static void upHeap(ArrayList<Integer> arr,int index) {
        /*

        Present Representation

            4
         5     7
      10   6 9   8
    3


        Modified Representation

            3
         4     7
       5   6 9   8
    10
         */
        if (index == 0) return;
        int parent = index/2;

        if (arr.get(index) < arr.get(parent)) swapElements(arr,index,parent);

        upHeap(arr,parent);
    }

    static void removeElement(ArrayList<Integer> arr,int index) {
        /*
        Present Representation

            3
         4     7
       5   6 9   8
    10


       Modified Representation

            3
         4     8
       5   6 9   10


         */
        int size = arr.size();

        swapElements(arr,index,size-1);

        arr.remove(size-1);
        heapify(arr,index,arr.size());
    }
}
