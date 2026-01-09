package Recursion.RecursionSubsequencePattern;

public class PrintAllStringSubsequence {
    public static void main(String[] args) {
        String input = "abc";
        printSubsequences(input, 0, "");
    }

    public static void printSubsequences(String input, int index, String current){
        //base case
        if (index == input.length()){
            System.out.print(current + ", ");
            return;
        }

        //ab
        //pick
        //current = current + input.charAt(index);
        printSubsequences(input, index+1, current+input.charAt(index)); //abc
        //ab

        //no pick
        printSubsequences(input, index+1, current);
    }
}
