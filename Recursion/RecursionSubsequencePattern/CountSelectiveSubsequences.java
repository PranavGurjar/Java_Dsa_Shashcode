package Recursion.RecursionSubsequencePattern;

public class CountSelectiveSubsequences {
    public static void main(String[] args) {
        String input = "abc";
        int res = printCountSelectiveSubsequences(input, 0, "");
        System.out.println("Count of \'a\' : "+res);
    }

    public static int printCountSelectiveSubsequences(String input, int index, String current){
        //base case
        if (index == input.length()){
            if (current.startsWith("a")){
                return 1;
            }
            return 0;
        }

        //ab
        //pick
        //current = current + input.charAt(index);
        int pick = printCountSelectiveSubsequences(input, index+1, current+input.charAt(index)); //abc
        //ab

        //no pick
        int noPick = printCountSelectiveSubsequences(input, index+1, current);

        return pick + noPick;
    }
}
