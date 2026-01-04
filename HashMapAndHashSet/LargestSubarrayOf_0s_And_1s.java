package HashMapAndHashSet;

import java.util.HashMap;


public class LargestSubarrayOf_0s_And_1s {
    public static void main(String[] args) {
        int []arr = {0, 1, 0, 0, 0, 1, 0, 1, 0, 0};

        int maxLen = maxLen(arr);
        System.out.println("LargestSubarrayOf_0s_And_1s : "+maxLen);
    }

    public static int maxLen(int[] arr) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);  //to handle subarray with sum 0 and starting from index 0
        int len = 0, maxLen = 0, sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum = (arr[i] == 0)? (sum - 1): (sum + 1);
            if (sumMap.containsKey(sum)){
                len = i - sumMap.get(sum);
                maxLen = Math.max(maxLen, len);
            }
            else {
                sumMap.put(sum, i);
            }
        }
        return maxLen;
    }
}
