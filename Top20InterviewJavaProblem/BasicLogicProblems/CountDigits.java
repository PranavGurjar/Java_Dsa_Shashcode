package Top20InterviewJavaProblem.BasicLogicProblems;

public class CountDigits {
    static int countDigits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n /= 10;
        }
        return count;
    }

}
