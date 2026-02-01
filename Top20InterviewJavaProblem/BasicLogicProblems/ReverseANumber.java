package Top20InterviewJavaProblem.BasicLogicProblems;

public class ReverseANumber {
    static int reverseNumber(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}
