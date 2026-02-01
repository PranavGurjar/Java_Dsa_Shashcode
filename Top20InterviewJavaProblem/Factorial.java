package Top20InterviewJavaProblem;

public class Factorial {
    static int factRecursive(int n){
        if(n==0) return 1;
        return n * factRecursive(n-1);
    }
    static int factLoop(int n){
        int result = 1;
        for(int i=1; i<=n; i++) result *= i;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(factRecursive(5));
        System.out.println(factLoop(5));
    }
}
