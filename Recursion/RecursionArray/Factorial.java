package Recursion;

public class Factorial {
    public static void main(String[] args) {
        int num = 5;
        System.out.println("Factorial1("+num+") : "+factorial1(num));

        System.out.println("Factorial2("+num+") : "+factorial2(num));
    }

    public static int factorial2(int num){
        if (num <= 1) return 1;

        return num * factorial2(num-1);
    }

    public static int factorial1(int num){
        if (num == 0 || num == 1) return 1;

        return num * factorial1(num-1);
    }
}
