package Dynamic_Programming;

import java.util.Arrays;

public class CoinChange_1 {
    public static void main(String[] args) {
        int []coins = {1, 2, 5};
        int amount = 11;

        int coinChange1 = coinChange1(coins, amount);
        System.out.println("coinChange1 : "+coinChange1);

        int coinChange2 = coinChange2(coins, amount);
        System.out.println("coinChange2 : "+coinChange2);

        int coinChange3 = coinChange3(coins, amount);
        System.out.println("coinChange3 : "+coinChange3);

        int coinChange4 = coinChange4(coins, amount);
        System.out.println("coinChange4 : "+coinChange4);

    }

    //recursive approach
    public static int coinChange1(int[] coins, int amount) {
        int n = coins.length;
        int res = recur1(coins, amount, n-1);
        if (res == (int) (1e9)){
            return -1;
        }
        return res;
    }

    public static int recur1(int[] coins, int amount, int index){
        //base case
        if (index == 0){
            if (amount % coins[index] == 0){
                return amount / coins[index];
            }
            return (int) (1e9);
        }

        int pick = (int) (1e9);
        if (amount >= coins[index]){
            pick = 1 + recur1(coins, amount - coins[index], index);
        }
        int noPick = recur1(coins, amount, index-1);
        return Math.min(pick, noPick);
    }

    //top down approach
    public static int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int res = recur2(coins, amount, n-1, dp);
        if (res == (int) (1e9)){
            return -1;
        }
        return res;
    }

    public static int recur2(int[] coins, int amount, int index, int dp[][]){
        //base case
        if (index == 0){
            if (amount % coins[index] == 0){
                dp[index][amount] = amount / coins[index];
                return amount / coins[index];
            }
            dp[index][amount] = (int) (1e9);
            return (int) (1e9);
        }

        if (dp[index][amount] != -1){
            return dp[index][amount];
        }

        int pick = (int) (1e9);
        if (amount >= coins[index]){
            pick = 1 + recur2(coins, amount - coins[index], index, dp);
        }
        int noPick = recur2(coins, amount, index-1, dp);
        dp[index][amount] = Math.min(pick, noPick);
        return dp[index][amount];
    }

    //bottom up approach
    public static int coinChange3(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for (int a = 0; a < amount+1; a++) {
            if (a % coins[0] == 0){
                dp[0][a] = a / coins[0];
            }
            else {
                dp[0][a] = (int) (1e9);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int a = 0; a < amount+1; a++) {
                int pick = (int) (1e9);
                if (a >= coins[i]){
                    pick = 1 + dp[i][a - coins[i]];
                }
                int noPick = dp[i-1][a];
                dp[i][a] = Math.min(pick, noPick);
            }
        }

        if (dp[n-1][amount] == (int) (1e9)){
            return -1;
        }
        return dp[n-1][amount];
    }

    //bottom up space optimization
    public static int coinChange4(int[] coins, int amount) {
        int n = coins.length;
        int prev[] = new int[amount+1];
        for (int a = 0; a < amount+1; a++) {
            if (a % coins[0] == 0){
                prev[a] = a / coins[0];
            }
            else {
                prev[a] = (int) (1e9);
            }
        }

        for (int i = 1; i < n; i++) {
            int cur[] = new int[amount+1];
            for (int a = 0; a < amount+1; a++) {
                int pick = (int) (1e9);
                if (a >= coins[i]){
                    pick = 1 + cur[a - coins[i]];
                }
                int noPick = prev[a];
                cur[a] = Math.min(pick, noPick);
            }
            prev = cur;
        }

        if (prev[amount] == (int) (1e9)){
            return -1;
        }
        return prev[amount];
    }
}
