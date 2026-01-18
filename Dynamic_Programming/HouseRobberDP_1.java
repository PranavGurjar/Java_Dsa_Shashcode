package Dynamic_Programming;

import java.util.Arrays;


public class HouseRobberDP_1 {
    public static void main(String[] args) {
        int []nums = {2,7,9,3,1};
        int rob1 = rob1(nums);
        System.out.println("rob1 : "+rob1);

        int rob2 = rob2(nums);
        System.out.println("rob2 : "+rob2);

        int rob3 = rob3(nums);
        System.out.println("rob3 : "+rob3);

        int rob4 = rob4(nums);
        System.out.println("rob4 : "+rob4);
    }

    //recursive approach
    public static int rob1(int[] nums) {
        int n = nums.length;
        return recur1(nums, n-1);
    }

    public static int recur1(int nums[], int index){
        //base case
        if (index == 0){
            return nums[0];
        }
        if (index == -1){
            return 0;
        }

        //pick and no pick logic
        int pick = nums[index] + recur1(nums, index-2);
        int noPick = 0 + recur1(nums, index-1);
        return Math.max(pick, noPick);
    }

    //top down approach
    public static int rob2(int[] nums) {
        int n = nums.length;
        int []dp = new int[n+1];
        Arrays.fill(dp, -1);
        return recur2(nums, n, dp);
    }

    public static int recur2(int nums[], int index, int dp[]){
        //base case
        if (index == 1){
            dp[index] = nums[0];
            return nums[0];
        }
        if (index == 0){
            dp[index] = 0;
            return 0;
        }

        if (dp[index] != -1){
            return dp[index];
        }

        //pick and no pick logic
        int pick = nums[index-1] + recur2(nums, index-2, dp);
        int noPick = 0 + recur2(nums, index-1, dp);
        dp[index] = Math.max(pick, noPick);
        return dp[index];
    }

    //bottom up approach
    public static int rob3(int[] nums) {
        int n = nums.length;
        int []dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int state = 2; state < n+1; state++) {
            //pick and no pick logic
            int pick = nums[state-1] + dp[state-2];
            int noPick = 0 + dp[state-1];
            dp[state] = Math.max(pick, noPick);
        }
        return dp[n];
    }

    //bottom up space optimization
    public static int rob4(int[] nums) {
        int n = nums.length;

        if (n == 1) return nums[0];

        int []dp = new int[n+1];
        int prev2 = 0;
        int prev1 = nums[0];
        int ans = 0;
        for (int state = 2; state < n+1; state++) {
            //pick and no pick logic
            int pick = nums[state-1] + prev2;
            int noPick = 0 + prev1;
            ans = Math.max(pick, noPick);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}
