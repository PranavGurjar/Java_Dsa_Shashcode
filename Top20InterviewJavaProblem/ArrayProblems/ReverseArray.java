package Top20InterviewJavaProblem.ArrayProblems;

public class ReverseArray {
    public static void main(String[] args) {
        int arr[] = {5, 1, 3, 2, 4};
        int n = arr.length;

        System.out.print("Before Reverse Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();

        reverseArray(arr);

        System.out.print("After Reverse Array : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }
    static void reverseArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
    }
}
