package Sliding_Window_Technique_2;

import java.util.ArrayDeque;
import java.util.Deque;


public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int []arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] maxSlidingWindow = maxSlidingWindow(arr, 3);
        System.out.print("maxSlidingWindow : ");
        for (int i = 0; i < maxSlidingWindow.length; i++) {
            System.out.print(maxSlidingWindow[i]);
            if (i != maxSlidingWindow.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int []res = new int[n-k+1];

        if (n == 0){
            return res;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        while (index < k){
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[index]){
                deque.pollLast();
            }
            deque.offerLast(index);
            index++;
        }
        res[0] = nums[deque.peekFirst()];
        // i=1
        // i-1 <=
        // i+k-1
        // 0, 1, 2
        // 1, 2, 3
        for (int i = 1; i < n-k+1; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= (i-1)){
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i+k-1]){
                deque.pollLast();
            }
            deque.offerLast(i+k-1);
            res[i] = nums[deque.peekFirst()];
        }
        return res;
    }
}
