package Dynamic_Programming;

import java.util.ArrayList;

public class PrintLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int []nums = {10,9,2,5,3,7,101,18};

        System.out.print("Print LIS : ");
        printLIS(nums);

        System.out.println();
    }

    public static int printLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        int prev[] = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            prev[i] = i;
        }
        int maxLen = 1;
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int p = 0; p < i; p++) {
                if (nums[p] < nums[i]){
                    if (lis[i] < 1 + lis[p]){
                        lis[i] = 1 + lis[p];
                        prev[i] = p;
                    }
                }
            }
            if (lis[i] > maxLen){
                maxLen = lis[i];
                maxIndex = i;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[maxIndex]);
        while (maxIndex != prev[maxIndex]){
            maxIndex = prev[maxIndex];
            list.add(0, nums[maxIndex]);    //handling of reverse
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ", ");
        }
        return maxLen;
    }
}
