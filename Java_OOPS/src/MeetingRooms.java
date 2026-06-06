import java.util.Arrays;
import java.util.Comparator;
import java.util.Collections;

class TimeComparator implements Comparator<int[]> {
    public int compare(int[] a,int[] b) {
        int startTime = Integer.compare(a[0],b[0]);
        int endTime = Integer.compare(b[1],a[1]);

        return (startTime == 0) ? endTime:startTime;
    }
}
public class MeetingRooms {
    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,3},{1,5},{8,10}};

        System.out.println(Arrays.deepToString(intervals));

        // Arrays.sort(intervals,new TimeComparator());

        Arrays.sort(intervals,(a,b) -> {
            int startTime = Integer.compare(a[0],b[0]);
            int endTime = Integer.compare(b[1],a[1]);

            return (startTime == 0) ? endTime:startTime;
        });

        System.out.println(Arrays.deepToString(intervals));

        int[] arr = {5,4,3,2,1};
    }
}
