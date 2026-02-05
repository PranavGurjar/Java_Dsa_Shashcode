package Top20InterviewJavaProblem.BasicLogicProblems;

public class PrimeNumberCheck {
    public static void main(String[] args) {
        int n = 10;
        boolean prime = isPrime(n);
        System.out.println(n+" is Prime : "+prime);
    }
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }
}
