package Top20InterviewJavaProblem.ArrayProblems;

public class SecondSmallest {
    public static void main(String[] args) {
        int []arr = {5, 3, 4, 2, 1};
        System.out.print("Before Second Smallest : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+", ");
        }
        System.out.println();

        int secondSmallest = secondSmallest(arr);
        System.out.println("secondSmallest : "+secondSmallest);
    }

    static int secondSmallest(int[] arr) {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int x : arr) {
            if (x < first) {
                second = first;
                first = x;
            } else if (x < second && x != first) {
                second = x;
            }
        }
        return second;
    }
}
