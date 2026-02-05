package Top20InterviewJavaProblem.BasicLogicProblems;

public class ArmstrongNumber {
    public static void main(String[] args) {
        //1³ + 5³ + 3³
        //= 1 + 125 + 27
        //= 153
        int n = 153;
        boolean armstrong = isArmstrong(n);
        System.out.println(n+" is Armstrong : "+armstrong);
    }
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
