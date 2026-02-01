package Top20InterviewJavaProblem.BasicLogicProblems;

public class ArmstrongNumber {
    static boolean isArmstrong(int n) {
        int temp = n, sum = 0;
        while (n != 0) {
            int d = n % 10;
            sum += d * d * d;
            n /= 10;
        }
        return sum == temp;
    }
}
