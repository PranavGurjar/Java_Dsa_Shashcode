package Top20InterviewJavaProblem.BasicLogicProblems;

public class SwapNumbers {
    public static void main(String[] args) {
        int a = 5, b = 10;
        int temp = a;
        a = b;
        b = temp;

        a = a + b;
        b = a - b;
        a = a - b;

    }
}
