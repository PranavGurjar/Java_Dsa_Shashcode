package Dynamic_Programming;


public class PerfectSumProblem {
    public static void main(String[] args) {
        int []nums = {2, 5, 1, 4, 3};
//        int []nums = {3, 0, 24};
//        int []nums = {0, 10, 0};

        int target = 10; //10, 24, 0

        int perfectSum1 = perfectSum1(nums, target);
        System.out.println("PerfectSum1 : "+perfectSum1);

        int perfectSum2 = perfectSum2(nums, target);
        System.out.println("PerfectSum2 : "+perfectSum2);

        int perfectSum3 = perfectSum3(nums, target);
        System.out.println("PerfectSum3 : "+perfectSum3);

        int perfectSum4 = perfectSum4(nums, target);
        System.out.println("PerfectSum4 : "+perfectSum4);
    }

    //recursive approach
    public static int perfectSum1(int[] nums, int target) {
        int n = nums.length;
        return recur1(nums, target, n-1);
    }

    public static int recur1(int nums[], int target, int index){
        //base case
        if (index == 0){
            if (target == 0 && nums[index] == 0) return 2;
            else if (target == 0) return 1;
            else if (target == nums[index]) return 1;
            else return 0;
        }

        int pick = 0;
        if (nums[index] <= target){
            pick = recur1(nums, target - nums[index], index-1);
        }
        int noPick = recur1(nums, target, index-1);

        return pick + noPick;
    }

    //dynamic programming
    //top down approach
    public static int perfectSum2(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n][target+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < target+1; j++) {
                dp[i][j] = -1;
            }
        }
        return recur2(nums, target, n-1, dp);
    }

    public static int recur2(int nums[], int target, int index, int [][]dp){
        //base case
        if (index == 0){
            if (target == 0 && nums[index] == 0) {
                dp[index][target] = 2;
                return 2;
            }
            else if (target == 0) {
                dp[index][target] = 1;
                return 1;
            }
            else if (target == nums[index]) {
                dp[index][target] = 1;
                return 1;
            }
            else {
                dp[index][target] = 0;
                return 0;
            }
        }

        if (dp[index][target] != -1){
            return dp[index][target];
        }

        int pick = 0;
        if (nums[index] <= target){
            pick = recur2(nums, target - nums[index], index-1, dp);
        }
        int noPick = recur2(nums, target, index-1, dp);

        dp[index][target] = pick + noPick;
        return dp[index][target];
    }

    //bottom up approach
    public static int perfectSum3(int[] nums, int target) {
        int n = nums.length;
        int dp[][] = new int[n][target+1];

        //base case
        for (int t = 0; t < target+1; t++) {
            if (t == 0 && nums[0] == 0) {
                dp[0][t] = 2;
            }
            else if (t == 0) {
                dp[0][t] = 1;
            }
            else if (t == nums[0]) {
                dp[0][t] = 1;
            }
            else {
                dp[0][t] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < target+1; j++) {
                int pick = 0;
                if (nums[i] <= j){
                    pick = dp[i-1][j - nums[i]];
                }
                int noPick = dp[i-1][j];

                dp[i][j] = pick + noPick;
            }
        }
        return dp[n-1][target];
    }

    //bottom up approach optimization
    public static int perfectSum4(int[] nums, int target) {
        int n = nums.length;
        int prev[] = new int[target+1];

        //base case
        for (int t = 0; t < target+1; t++) {
            if (t == 0 && nums[0] == 0) {
                prev[t] = 2;
            }
            else if (t == 0) {
                prev[t] = 1;
            }
            else if (t == nums[0]) {
                prev[t] = 1;
            }
            else {
                prev[t] = 0;
            }
        }

        for (int i = 1; i < n; i++) {
            int cur[] = new int[target+1];
            for (int j = 0; j < target+1; j++) {
                int pick = 0;
                if (nums[i] <= j){
                    pick = prev[j - nums[i]];
                }
                int noPick = prev[j];

                cur[j] = pick + noPick;
            }
            prev = cur;
        }
        return prev[target];
    }
}
