package Top20InterviewJavaProblem.BasicLogicProblems;

public class FibonacciSeries {
    static void fibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
    }

}
