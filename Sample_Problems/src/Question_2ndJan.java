import java.util.ArrayList;

public class Question_2ndJan {
    public static void main(String[] args) {
        // Question - 1
        int[] sales = {0,1,3,2,4,2,1,3,0,1,2,4,4,3,0};
        int[] result = calculateProductsSoldByType(sales);

        System.out.println("Product 0 sold: "+result[4]);

        // Question - 2
        int[] temp = {34,36,37,33,35,38,32};
        System.out.println(daysWithAboveAverageTemperature(temp));

        // Question - 3
        int[] scores = {68,87,78,85,90};
        float[] stats = printStatistics(scores);

        System.out.println("Highest Score: "+stats[0]);
        System.out.println("Lowest Score: "+stats[1]);
        System.out.println("Average Score: "+stats[2]);

        // Question - 4
        int[] ratings = {4,5,3,2,5,4,3,5,1,4,2};
        int[] ratingType = ratingCount(ratings);
        System.out.println("1 star: "+ratingType[4]);
    }

    static int[] calculateProductsSoldByType(int[] sales) {
        int[] count = new int[5];

        for (int item: sales) {
            count[item]++;
        }

        return count;
    }

    static ArrayList<Integer> daysWithAboveAverageTemperature(int[] temp) {
        // Finding average
        int sum = 0;
        for (int val: temp) {
            sum += val;
        }

        float average = (float) sum/temp.length;

        // Find days with above average temperature
        ArrayList<Integer> result = new ArrayList<>();

        for (int val: temp) {
            if (val > average) {
                result.add(val);
            }
        }

        return result;
    }

    static float[] printStatistics(int[] scores) {
        int sum = scores[0];
        int max = scores[0];
        int min = scores[0];

        for (int i = 1;i<scores.length;i++) {
            if (scores[i] > max) {
                max = scores[i];
            }

            if (scores[i] < min) {
                min = scores[i];
            }

            sum += scores[i];
        }

        float average = (float) sum/scores.length;

        return new float[] {(float) max,(float) min,(float) average};
    }

    static int[] ratingCount(int[] ratings) {
        int[] count = new int[5];

        for (int rating: ratings) {
            count[rating-1]++;
        }

        return count;
    }
}
