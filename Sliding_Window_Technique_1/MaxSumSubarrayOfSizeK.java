package Sliding_Window_Technique_1;

public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int []arr = {100, 200, 300, 400};
        int maxSubarraySum = maxSubarraySum(arr, 2);
        System.out.println("maxSubarraySum : "+maxSubarraySum);
    }

    public static int maxSubarraySum(int[] arr, int K) {
        int N = arr.length;
        int maxSum = 0;
        int sum = 0;

        int index = 0;
        while (index < N && index < K){     //k
            sum += arr[index];
            index++;
        }
        maxSum = sum;
        for (int i = 1; i < (N-K+1); i++) {     //n-k
            int prevElement = arr[i-1];
            int nextElement = arr[i+K-1];
            sum = sum - prevElement + nextElement;
            maxSum = Math.max(maxSum, sum);
        }
        //K + N - K => N
        return maxSum;
    }
}
