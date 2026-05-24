/*
Problem Statement: Given a number of stairs and a frog, the frog wants to climb from the 0th stair to the (N-1)th stair. At a time the frog can climb either one or two steps. A height[N] array is also given. Whenever the frog jumps from a stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. We need to return the minimum energy that can be used by the frog to jump from stair 0 to stair N-1
 */

public class Frog_Jump {
    public static void main(String[] args) {
//        int[] heights = {2,1,3,5,4};
        int[] heights = {7,5,1,2};

        System.out.println(minEnergy(heights));
    }

    static int minEnergy(int[] heights) {
        int n = heights.length;
        int[] cost = new int[n];

        cost[0] = 0;
        cost[1] = Math.abs(heights[1]-heights[0]);

        for (int i = 2; i < n; i++) {
            cost[i] = Math.min(cost[i-1]+Math.abs(heights[i]-heights[i-1]),cost[i-2]+Math.abs(heights[i]-heights[i-2]));
        }

        return cost[n-1];
    }
}
