package Sliding_Window_Technique_1;

public class SmallestSubarrayWithSumGreaterThanX {
    public static void main(String[] args) {
        int []arr = {1, 4, 45, 6, 0, 19};
        int smallestSubWithSum = smallestSubWithSum(arr, 51);
        System.out.println("smallestSubWithSum : "+smallestSubWithSum);
    }

    public static int smallestSubWithSum(int[] arr, int x) {
        int n = arr.length;
        int windowStart = 0;
        int windowEnd = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int len = 0;
        while (windowEnd < n){
            //expansion
            sum += arr[windowEnd];
            if (sum > x){
                len = windowEnd - windowStart + 1;
                minLen = Math.min(minLen, len);
                //shrinking
                while (windowStart < windowEnd && sum > x){
                    sum -= arr[windowStart];
                    windowStart++;
                    if (sum > x){
                        len = windowEnd - windowStart + 1;
                        minLen = Math.min(minLen, len);
                    }
                }
            }
            windowEnd++;
        }
        return (minLen == Integer.MAX_VALUE)?0:minLen;
    }
}
