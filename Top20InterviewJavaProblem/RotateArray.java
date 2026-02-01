package Top20InterviewJavaProblem;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        rotate(arr, 2);
        System.out.println(Arrays.toString(arr));
    }
    static void rotate(int[] arr, int k){
        k %= arr.length;
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }
    static void reverse(int[] arr, int l, int r){
        while(l < r){
            int t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            l++; r--;
        }
    }
}
