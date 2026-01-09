package Recursion.RecursionSubsequencePattern;

public class PrintSelectiveStringSubsequences {
    public static void main(String[] args) {
        String input = "abc";
        printSelectiveSubsequences(input, 0, "");
    }

    public static void printSelectiveSubsequences(String input, int index, String current){
        //base case
        if (index == input.length()){
            if (current.startsWith("a")){
                System.out.print(current + ", ");
            }
            return;
        }

        //ab
        //pick
        //current = current + input.charAt(index);
        printSelectiveSubsequences(input, index+1, current+input.charAt(index)); //abc
        //ab

        //no pick
        printSelectiveSubsequences(input, index+1, current);
    }
}
