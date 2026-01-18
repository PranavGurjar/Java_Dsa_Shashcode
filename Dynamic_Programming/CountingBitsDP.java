package Dynamic_Programming;


public class CountingBitsDP {
    public static void main(String[] args) {
        int n = 5;
        int[] countBits = countBits(n);
        System.out.print("countBits : ");
        for (int i = 0; i < countBits.length; i++) {
            System.out.print(countBits[i]+" ");
        }
    }

    public static int[] countBits(int n) {
        int dp[] = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = dp[i>>1] + (i & 1);
        }
        return dp;
    }
}
