package Recursion.RecursionString;

public class PrintStringUsingRecursion {
    public static void main(String[] args) {
        String str = "SHASHCODE";
        System.out.print("String : ");
        printChars(0, str);
    }
    public static void printChars(int index, String str){
        if (index == str.length()) return;  //base case
        System.out.print(str.charAt(index));
        printChars(index+1, str);
    }
}
