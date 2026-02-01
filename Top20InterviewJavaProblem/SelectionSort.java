package Top20InterviewJavaProblem;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[min]) min = j;
            }
            int t = arr[min]; arr[min] = arr[i]; arr[i] = t;
        }
    }
}
