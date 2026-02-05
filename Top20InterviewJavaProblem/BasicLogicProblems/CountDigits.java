package Top20InterviewJavaProblem.BasicLogicProblems;

public class CountDigits {
    public static void main(String[] args) {
        int n = 1234;
        int countDigits = countDigits(n);
        System.out.println("countDigits : "+countDigits);
    }
    static int countDigits(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n /= 10;
        }
        return count;
    }
}
