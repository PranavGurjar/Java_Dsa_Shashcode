package HashMapAndHashSet;

import java.util.Arrays;
import java.util.HashSet;


public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int []arr = {2, 0, 1, 1, 7, 6, 9, 8, 8};

        int longestConsecutive1 = longestConsecutive1(arr);
        System.out.println("longestConsecutive1 : "+longestConsecutive1);

        int longestConsecutive2 = longestConsecutive2(arr);
        System.out.println("longestConsecutive2 : "+longestConsecutive2);
    }

    //NlogN
    public static int longestConsecutive1(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);  //NlogN
        int maxLen = 1;
        int prev = nums[0];
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (prev == nums[i]){
                continue;
            }
            if (nums[i] == (prev+1)){
                len++;
            }
            else {
                len = 1;
            }
            prev = nums[i];
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    public static int longestConsecutive2(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {   //O(N)
            set.add(nums[i]);
        }
        int maxLen = 0;
        //O(N + N) -> O(2N)
        for (Integer element : set){    //1
            int prevElement = element - 1;  //0
            if (!set.contains(prevElement)){
                int len = 1;
                int nextElement = element + 1;  //2
                while (set.contains(nextElement)){
                    len++;  //2, 3
                    nextElement++;  //3, 4
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}


