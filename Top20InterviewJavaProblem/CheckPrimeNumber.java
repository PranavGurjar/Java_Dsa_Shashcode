package Top20InterviewJavaProblem;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime1(17));
        isPrime2(17);
    }
    static boolean isPrime1(int n){
        if(n <= 1) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    static void isPrime2(int n) {
        for (int k = 0; k <= n; k++) {

            if (k <= 1) {
                System.out.println(k + " is non prime");
                continue;
            }

            boolean isPrime = true;

            for (int i = 2; i * i <= k; i++) {
                if (k % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime)
                System.out.println(k + " is prime");
            else
                System.out.println(k + " is non prime");
        }
    }

}