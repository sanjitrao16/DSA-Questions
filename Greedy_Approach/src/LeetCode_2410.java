// Maximum Matching of Players and Trainers

import java.util.Arrays;

public class LeetCode_2410 {
    public static void main(String[] args) {
        int[] players = {4,7,9};
        int[] trainers = {8,2,5,8};

        System.out.println(matchPlayersAndTrainers(players,trainers));
    }

    static int matchPlayersAndTrainers(int[] players,int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0;
        int j = 0;
        int maxMatching = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                maxMatching++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return maxMatching;
    }
}
