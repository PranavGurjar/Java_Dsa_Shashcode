package Top20InterviewJavaProblem.ArrayProblems;

public class Largest_And_Smallest {
    static void maxMin(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int x : arr) {
            if (x > max) max = x;
            if (x < min) min = x;
        }
    }

}
