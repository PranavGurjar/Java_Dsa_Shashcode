package Top20InterviewJavaProblem.ArrayProblems;

public class Largest_And_Smallest {
    public static void main(String[] args) {
        int []arr = {5, 3, 4, 2, 1};
        System.out.print("Before Min and Max : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();

        maxMin(arr);
    }
    public static void maxMin(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int x : arr) {
            if (x > max) max = x;
            if (x < min) min = x;
        }
        System.out.println("max : "+max+", min : "+min);
    }
}
