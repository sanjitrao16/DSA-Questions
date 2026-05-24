// Lemonade Change

public class LeetCode_860 {
    public static void main(String[] args) {
        int[] lemonadeBills = {5,5,10,10,20};
        System.out.println(lemonadeChange(lemonadeBills));
    }

    static boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) return false;
        int fiveChange = 1;
        int tenChange = 0;

        for (int i = 1;i<bills.length;i++) {
            if (bills[i] == 5) fiveChange += 1;
            else if (bills[i] == 10) {
                if (fiveChange < 0) return false;
                fiveChange -=1;
                tenChange += 1;
            }

            else if (bills[i] == 20) {
                if (fiveChange > 0 && tenChange > 0) {
                    fiveChange--;
                    tenChange--;
                }

                else if (fiveChange >= 3) {
                    fiveChange -=3;
                }

                else return false;
            }
        }

        return true;
    }
}
