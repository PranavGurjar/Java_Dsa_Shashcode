package Recursion.RecursionSubsequencePattern;

public class CountSubsequences {
    public static void main(String[] args) {
        String input = "abc";
        int res = printCountSubsequences(input, 0, "");
        System.out.println("Count : "+res);
    }

    public static int printCountSubsequences(String input, int index, String current){
        //base case
        if (index == input.length()){
//            System.out.print(current + ", ");
            return 1;
        }

        //ab
        //pick
        //current = current + input.charAt(index);
        int pick = printCountSubsequences(input, index+1, current+input.charAt(index)); //abc
        //ab

        //no pick
        int noPick = printCountSubsequences(input, index+1, current);

        return pick + noPick;
    }
}
