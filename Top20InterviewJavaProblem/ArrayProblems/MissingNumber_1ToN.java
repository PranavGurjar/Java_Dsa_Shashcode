package Top20InterviewJavaProblem.ArrayProblems;

public class MissingNumber_1ToN {
    public static void main(String[] args) {
        int arr[] = {6, 1, 3, 2, 4};
        int n = arr.length;
        System.out.print("Before Missing Number : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();

        int missingNumber = missingNumber(arr, n+1);
        System.out.println("missingNumber : "+missingNumber);

    }
    static int missingNumber(int[] arr, int n) {
        int sum = n * (n + 1) / 2;
        for (int x : arr) sum -= x;
        return sum;
    }
}
