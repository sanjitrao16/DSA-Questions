// Job Sequencing Problem
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Job {
    int jobId;
    int deadline;
    int profit;
    public Job(int jobId,int deadline,int profit) {
        this.jobId = jobId;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class GFG_Job_Sequencing {
    public static void main(String[] args) {
        int[] deadline = {2, 1, 2, 1, 1};
        int[] profit = {100, 19, 27, 25, 15};

        System.out.println(jobSequencing(deadline,profit));
    }

    static ArrayList<Integer> jobSequencing(int[] deadline,int[] profit) {
        int n = deadline.length;
        ArrayList<Job> jobList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jobList.add(new Job(i,deadline[i],profit[i]));
        }

        // Sorting jobList based on deadline
        Collections.sort(jobList,(o1,o2) -> Integer.compare(o2.profit,o1.profit));

        int maxDeadline = jobList.get(0).deadline;
        for (int i = 1; i < n; i++) {
            maxDeadline = Math.max(maxDeadline,jobList.get(i).deadline);
        }

        int[] slot = new int[maxDeadline+1];
        Arrays.fill(slot,-1);

        int jobCount = 0, totalProfit = 0;

        for (int i = 0;i<n;i++) {
            Job d = jobList.get(i);
            for (int j = d.deadline; j > 0; j--) {
                if (slot[j] == -1) {
                    slot[j] = d.jobId;
                    jobCount++;
                    totalProfit += d.profit;
                    break;
                }
            }
        }

        return new ArrayList<>(List.of(jobCount,totalProfit));
    }
}
