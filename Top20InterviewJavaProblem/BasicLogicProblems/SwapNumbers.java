package Top20InterviewJavaProblem.BasicLogicProblems;

public class SwapNumbers {
    public static void main(String[] args) {
        int a = 5, b = 10;
        System.out.println("Before Swaping : a : "+a+" , b : "+b);

        int temp = a;
        a = b;
        b = temp;
        System.out.println("After 1st Swaping : a : "+a+" , b : "+b);

        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("After 2nd Swaping : a : "+a+" , b : "+b);
    }
}
