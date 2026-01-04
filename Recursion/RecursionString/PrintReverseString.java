package Recursion.RecursionString;

public class PrintReverseString {
    public static void main(String[] args) {
        String str = "SHASHCODE";
        System.out.print("String Reverse : ");
        printCharsReverse(0, str);
    }

    public static void printCharsReverse(int index, String str){
        if (index == str.length()) return;  //base case
        printCharsReverse(index+1, str);
        System.out.print(str.charAt(index));
    }
}
