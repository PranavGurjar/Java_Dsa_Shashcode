package HashMapAndHashSet;


import java.util.HashMap;

public class FindTheLongestLengthSubarrayWithSumDivisibleByK {
    public static void main(String[] args) {
        int []arr = {2, 7, 6, 1, 4, 5};

        int longestSubarrayDivK = longestSubarrayDivK(arr, 3);
        System.out.println("longestSubarrayDivK : "+longestSubarrayDivK);
    }

    public static int longestSubarrayDivK(int[] arr, int k) {
        HashMap<Integer, Integer> remMap = new HashMap<>();
        remMap.put(0, -1);  //to handle subarray starting from index 0
        int sum = 0, maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            int rem = (int) (sum % k);
            //convert negative remainder to positive
            if (rem < 0){
                rem = rem + k;
            }
            if (remMap.containsKey(rem)){
                int len = i - remMap.get(rem);  //UL - LL
                maxLen = Math.max(maxLen, len);
            }
            else {
                remMap.put(rem, i);
            }
        }
        return maxLen;
    }
}






//class Solution {
//    int longestSubarrayDivK(int[] arr, int k) {
//        HashMap<Long, Integer> remMap = new HashMap<>();
//        remMap.put(0L, -1);  //to handle subarray starting from index 0
//        long sum = 0;
//        int maxLen = 0;
//        for (int i = 0; i < arr.length; i++) {
//            sum += arr[i];
//            long rem = sum % k;
//            //convert negative remainder to positive
//            if (rem < 0){
//                rem = rem + k;
//            }
//            if (remMap.containsKey(rem)){
//                int len = i - remMap.get(rem);  //UL - LL
//                maxLen = Math.max(maxLen, len);
//            }
//            else {
//                remMap.put(rem, i);
//            }
//        }
//        return maxLen;
//    }
//}