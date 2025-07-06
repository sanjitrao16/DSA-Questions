// Best Time to Buy and Sell Stock
public class LeetCode_121 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 6, 9, 11};
        System.out.println(maxProfit(arr));
    }

    // Buying the stock when the price is least and selling it when the price is the highest
    static int maxProfit(int[] arr) {
        int maxProfit = 0;
        int buyPrice = arr[0];
        for (int i = 1;i<arr.length;i++) {
            if (arr[i] < buyPrice) {
                buyPrice = arr[i];
            }

            else {
                maxProfit = Math.max(maxProfit,arr[i]-buyPrice);
            }
        }

        return maxProfit;
    }
}
