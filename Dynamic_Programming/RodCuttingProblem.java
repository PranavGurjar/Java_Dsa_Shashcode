package Dynamic_Programming;

public class RodCuttingProblem {
    public static void main(String[] args) {
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};

        int cutRod1 = cutRod1(price);
        System.out.println("cutRod1 : " + cutRod1);

        int cutRod2 = cutRod2(price);
        System.out.println("cutRod2 : " + cutRod2);

        int cutRod3 = cutRod3(price);
        System.out.println("cutRod3 : " + cutRod3);

        int cutRod4 = cutRod4(price);
        System.out.println("cutRod4 : "+cutRod4);
    }

    //recursive approach
    public static int cutRod1(int[] price) {
        int N = price.length;
        return recur1(N, N-1, price);
    }

    public static int recur1(int N, int index, int []price){
        //base case
        if (index == 0){
            return N*price[index];
        }
        int pick = 0;
        int curLen = index+1;
        if (N >= curLen){
            pick = price[index] + recur1(N-curLen, index, price);
        }
        int noPick = 0 + recur1(N, index-1, price);
        return Math.max(pick, noPick);
    }

    //top down approach
    public static int cutRod2(int[] price) {
        int N = price.length;
        //(len, rodLen)
        int dp[][] = new int[N][N+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N+1; j++) {
                dp[i][j] = -1;
            }
        }
        return recur2(N, N-1, price, dp);
    }

    public static int recur2(int N, int index, int []price, int dp[][]){
        //base case
        if (index == 0){
            dp[index][N] = N*price[index];
            return N*price[index];
        }

        if (dp[index][N] != -1){
            return dp[index][N];
        }

        int pick = 0;
        int curLen = index+1;
        if (N >= curLen){
            pick = price[index] + recur2(N-curLen, index, price, dp);
        }
        int noPick = 0 + recur2(N, index-1, price, dp);
        dp[index][N] = Math.max(pick, noPick);
        return dp[index][N];
    }

    //bottom up approach
    public static int cutRod3(int[] price) {
        int N = price.length;

        int dp[][] = new int[N][N+1];   //(len, rodLen)

        for (int r = 0; r < N+1; r++) {     //len = 1
            dp[0][r] = r*price[0];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < N+1; j++) {
                int pick = 0;
                int curLen = i+1;
                if (j >= curLen){
                    pick = price[i] + dp[i][j-curLen];
                }
                int noPick = 0 + dp[i-1][j];
                dp[i][j] = Math.max(pick, noPick);
            }
        }
        return dp[N-1][N];
    }

    //bottom up optimize approach
    public static int cutRod4(int[] price) {
        int N = price.length;

        int prev[] = new int[N+1];   //(len, rodLen)

        for (int r = 0; r < N+1; r++) {     //len = 1
            prev[r] = r*price[0];
        }
        for (int i = 1; i < N; i++) {
            int cur[] = new int[N+1];
            for (int j = 0; j < N+1; j++) {
                int pick = 0;
                int curLen = i+1;
                if (j >= curLen){
                    pick = price[i] + cur[j-curLen];
                }
                int noPick = 0 + prev[j];
                cur[j] = Math.max(pick, noPick);
            }
            prev = cur;
        }
        return prev[N];
    }
}