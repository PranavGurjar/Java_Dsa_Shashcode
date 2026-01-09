package Backtracking;

import java.util.ArrayList;
import java.util.List;


public class GenerateParentheses {
    public static void main(String[] args) {
        int n = 3;
        List<String> generateParenthesis = generateParenthesis(n);
        System.out.println("generateParenthesis : "+generateParenthesis);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(""), n, 0, 0);
        return res;
    }

    public static void backtrack(List<String> res, StringBuilder current, int n, int open, int close){
        //base case
        if (open == n && close == n){
            res.add(current.toString());
            return;
        }

        if (open < n){
            current.append('(');
            backtrack(res, current, n, open+1, close);
            current.deleteCharAt(current.length()-1);
        }

        if (close < n && close < open){
            current.append(')');
            backtrack(res, current, n, open, close+1);
            current.deleteCharAt(current.length()-1);
        }
    }
}
