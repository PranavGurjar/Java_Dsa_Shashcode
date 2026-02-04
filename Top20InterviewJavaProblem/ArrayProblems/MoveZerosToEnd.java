package Top20InterviewJavaProblem.ArrayProblems;

public class MoveZerosToEnd {
    public static void main(String[] args) {
       int[] arr = {0, 1, 0, 3, 12};

        System.out.print("Before Move Zeros : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();

        moveZeros(arr);

        System.out.print("After Move Zeros : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();
    }
    static void moveZeros(int[] arr) {
        int index = 0;
        for (int x : arr){
            if (x != 0) {
                arr[index++] = x;
            }
        }
        while (index < arr.length) {
            arr[index++] = 0;
        }
    }
}
