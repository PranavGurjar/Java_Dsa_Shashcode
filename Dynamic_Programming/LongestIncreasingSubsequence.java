package Dynamic_Programming;

import java.util.Arrays;

class Solution {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n]; //{1, 1, 1, 1, 1, 1, 1};
        Arrays.fill(lis, 1);
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int p = 0; p < i; p++) {
                if (nums[p] < nums[i]){
                    lis[i] = Math.max(lis[i], 1+lis[p]);
                }
            }
            if (lis[i] > maxLen){
                maxLen = lis[i];
            }
        }
        return maxLen;
    }
}

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int []nums = {10,9,2,5,3,7,101,18};
        int lengthOfLIS = lengthOfLIS(nums);
        System.out.println("lengthOfLIS : "+lengthOfLIS);
    }

    //T -> N^2
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n]; //{1, 1, 1, 1, 1, 1, 1};
        Arrays.fill(lis, 1);
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            for (int p = 0; p < i; p++) {
                if (nums[p] < nums[i]){
                    lis[i] = Math.max(lis[i], 1+lis[p]);
                }
            }
            if (lis[i] > maxLen){
                maxLen = lis[i];
            }
        }
        return maxLen;
    }
}
