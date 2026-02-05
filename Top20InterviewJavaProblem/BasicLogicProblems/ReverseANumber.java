package Top20InterviewJavaProblem.BasicLogicProblems;

public class ReverseANumber {
    public static void main(String[] args) {
        int n = 1234;
        int reverseNumber = reverseNumber(n);
        System.out.println(n+" is Reverse Number : "+reverseNumber);
    }
    static int reverseNumber(int n) {
        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}
