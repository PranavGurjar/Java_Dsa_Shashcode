package Top20InterviewJavaProblem.BasicLogicProblems;

public class Factorial {
    static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) fact *= i;
        return fact;
    }

    static int factorialRec(int n) {
        if (n == 0) return 1;
        return n * factorialRec(n - 1);
    }

}
