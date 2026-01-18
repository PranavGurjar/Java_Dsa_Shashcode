package Dynamic_Programming;

import java.util.Arrays;


public class FibonacciNumberDP {
    public static void main(String[] args) {
        int n = 6;
        System.out.println("f1("+n+") : "+fib1(6));

        System.out.println("f2("+n+") : "+fib2(6));

        System.out.println("f3("+n+") : "+fib3(6));

    }

    //top down -> memorization
    public static int fib1(int n){
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return recur1(n, dp);
    }

    public static int recur1(int n, int dp[]){
        //base case
        if (n<=1){
            dp[n] = n;
            return dp[n];
        }

        if (dp[n] != -1){
            return dp[n];
        }

        dp[n] = fib1(n-1) + fib1(n-2);
        return dp[n];
    }

    //bottom up -> tabulation
    public static int fib2(int n){
        if (n <= 1){
            return n;
        }

        int dp[] = new int[n+1];

        //base case
        dp[0] = 0;
        dp[1] = 1;

        for (int state = 2; state <= n; state++) {
            dp[state] = dp[state-1] + dp[state-2];
        }
        return dp[n];
    }

    //optimize space
    public static int fib3(int n){
        if (n <= 1){
            return n;
        }

        int prev2 = 0;
        int prev1 = 1;
        int ans = 0;

        for (int state = 2; state <= n; state++) {
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }

        return ans;
    }
}
