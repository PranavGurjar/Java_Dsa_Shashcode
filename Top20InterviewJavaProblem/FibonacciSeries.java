package Top20InterviewJavaProblem;

public class FibonacciSeries {
    public static void main(String[] args) {
        fib(10);
    }
    static void fib(int n) {
        int a = 0, b = 1;
        System.out.print(a + " " + b + " ");
        for (int i = 2; i < n; i++) {
            int c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
