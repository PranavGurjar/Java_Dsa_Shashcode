package Recursion;



public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 4;

        System.out.println("Fibonacci Number index "+n+" : "+fib(n));
    }

    public static int fib(int n) {
        //if (n == 0) return 0;
        //if (n == 1) return 1;

        if (n <= 1) return n;

        return fib(n-1) + fib(n-2);
    }
}
