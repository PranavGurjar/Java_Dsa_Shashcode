package Dynamic_Programming;


public class _0_1_KnapsackProblem {
    public static void main(String[] args) {
        int W = 5;
        int []val = {10, 40, 30, 50, 20};
        int []wt = {5, 4, 6, 3, 1};

        int knapsack1 = knapsack1(W, val, wt);
        System.out.println("knapsack1 : "+ knapsack1);

        int knapsack2 = knapsack2(W, val, wt);
        System.out.println("knapsack2 : "+ knapsack2);

        int knapsack3 = knapsack3(W, val, wt);
        System.out.println("knapsack3 : "+ knapsack3);

        int knapsack4 = knapsack4(W, val, wt);
        System.out.println("knapsack4 : "+ knapsack4);
    }

    //recursive approach
    public static int knapsack1(int W, int val[], int wt[]) {
        int n = val.length;
        return recur1(W, val, wt, n-1);
    }

    public static int recur1(int capacity, int val[], int wt[], int index){
        //base case
        if (capacity == 0) return 0;
        if (index == 0){
            if (wt[index] <= capacity){
                return val[index];
            }
            else {
                return 0;
            }
        }

        int pick = 0;
        if (wt[index] <= capacity){
            pick = val[index] + recur1(capacity - wt[index], val, wt, index-1);
        }
        int noPick = 0 + recur1(capacity, val, wt, index-1);
        return Math.max(pick, noPick);
    }

    //dynamic programming
    //top down approach
    public static int knapsack2(int W, int val[], int wt[]) {
        int n = val.length;
        int dp[][] = new int[n][W+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < W+1; j++) {
                dp[i][j] = -1;
            }
        }
        return recur1(W, val, wt, n-1, dp);
    }

    public static int recur1(int capacity, int val[], int wt[], int index, int [][]dp){
        //base case
        if (capacity == 0) {
            dp[index][capacity] = 0;
            return 0;
        }
        if (index == 0){
            if (wt[index] <= capacity){
                dp[index][capacity] = val[index];
                return val[index];
            }
            else {
                dp[index][capacity] = 0;
                return 0;
            }
        }

        if (dp[index][capacity] != -1){
            return dp[index][capacity];
        }

        int pick = 0;
        if (wt[index] <= capacity){
            pick = val[index] + recur1(capacity - wt[index], val, wt, index-1, dp);
        }
        int noPick = 0 + recur1(capacity, val, wt, index-1, dp);
        dp[index][capacity] = Math.max(pick, noPick);
        return dp[index][capacity];
    }

    public static int knapsack3(int W, int val[], int wt[]) {
        int n = val.length;
        int dp[][] = new int[n][W+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c < W+1; c++) {
            if (wt[0] <= c){
                dp[0][c] = val[0];
            }
            else {
                dp[0][c] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < W+1; j++) {
                int pick = 0;
                if (wt[i] <= j){
                    pick = val[i] + dp[i-1][j-wt[i]];                 }
                int noPick = 0 + dp[i-1][j];
                dp[i][j] = Math.max(pick, noPick);
            }
        }
        return dp[n-1][W];
    }

    public static int knapsack4(int capacity, int val[], int wt[]) {
        int n = val.length;
        int prev[] = new int[capacity+1];

        prev[0] = 0;

        for (int c = 0; c < capacity+1; c++) {
            if (wt[0] <= c){
                prev[c] = val[0];
            }
            else {
                prev[c] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            int cur[] = new int[capacity+1];
            cur[0] = 0;
            for (int j = 1; j < capacity+1; j++) {
                int pick = 0;
                if (wt[i] <= j){
                    pick = val[i] + prev[j-wt[i]];                 }
                int noPick = 0 + prev[j];
                cur[j] = Math.max(pick, noPick);
            }
            prev = cur;
        }
        return prev[capacity];
    }
}