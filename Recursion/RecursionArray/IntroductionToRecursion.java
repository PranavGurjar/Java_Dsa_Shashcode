package Recursion;


public class IntroductionToRecursion {
    public static void main(String[] args) {
        System.out.print("Recursion Asc: ");
        printAsc(5);

        System.out.println();

        System.out.print("Recursion Desc: ");
        printDesc(5);
    }

    public static void printAsc(int num){
        if (num == 0) return;   //base case
        printAsc(num-1);    //Recursive call
        System.out.print(num+" ");  //task after recursion
    }

    public static void printDesc(int num){
        if (num == 0) return;   //base case
        System.out.print(num+" ");  //task recursion
        printDesc(num-1);   //Recursive call
    }
}
