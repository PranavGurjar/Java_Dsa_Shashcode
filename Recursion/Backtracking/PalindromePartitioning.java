package Backtracking;

import java.util.ArrayList;
import java.util.List;


public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> partition = partition(s);
        System.out.println("Partition res : "+partition);
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> current = new ArrayList<>();
        backtrack(0, s, res, current);
        return res;
    }

    private static void backtrack(int partIndex, String s, List<List<String>> res, List<String> current) {
        //base case
        int n = s.length();
        if (partIndex == n){
            res.add(new ArrayList<>(current));
            return;
        }
        for (int end = partIndex; end < n; end++) {
            //partIndex -> end, partIndex -> end + 1...
            if (isPalindrome(partIndex, end, s)){
                //0,2 -> 01
                current.add(s.substring(partIndex, end+1));
                backtrack(end+1, s, res, current);
                current.remove(current.size()-1);
            }
        }
    }

    private static boolean isPalindrome(int start, int end, String s) {
        while (start < end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

}
