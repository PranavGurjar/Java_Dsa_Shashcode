package Dynamic_Programming;


public class CoinChange_2 {
    public static void main(String[] args) {
        int []coins = {1, 2, 5};
        int amount = 5;

        int change = change(amount, coins);
        System.out.println("change : "+change);
    }

    //bottom up space optimization
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int prev[] = new int[amount+1];
        for (int a = 0; a < amount+1; a++) {
            if (a % coins[0] == 0){
                prev[a] = 1;
            }
            else {
                prev[a] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            int cur[] = new int[amount+1];
            for (int a = 0; a < amount+1; a++) {
                int pick = 0;
                if (a >= coins[i]){
                    pick = cur[a - coins[i]];
                }
                int noPick = prev[a];
                cur[a] = pick + noPick;
            }
            prev = cur;
        }

        return prev[amount];
    }
}
