package Top20InterviewJavaProblem.ArrayProblems;

public class MissingNumber_1ToN {
    static int missingNumber(int[] arr, int n) {
        int sum = n * (n + 1) / 2;
        for (int x : arr) sum -= x;
        return sum;
    }

}
