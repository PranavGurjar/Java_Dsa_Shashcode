package Top20InterviewJavaProblem.ArrayProblems;

public class MoveZerosToEnd {
    static void moveZeros(int[] arr) {
        int index = 0;
        for (int x : arr)
            if (x != 0) arr[index++] = x;
        while (index < arr.length) arr[index++] = 0;
    }

}
