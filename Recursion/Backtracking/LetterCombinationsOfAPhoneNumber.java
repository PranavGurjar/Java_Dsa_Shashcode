package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "23";
        List<String> letterCombinations1 = letterCombinations1(digits);
        System.out.println("letterCombinations1 : "+letterCombinations1);

        List<String> letterCombinations2 = letterCombinations2(digits);
        System.out.println("letterCombinations2 : "+letterCombinations2);

        List<String> letterCombinations3 = letterCombinations3(digits);
        System.out.println("letterCombinations3 : "+letterCombinations3);
    }

    public static List<String> letterCombinations1(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        backtrack1(0, digits, res, "", map);
        return res;
    }

    //digits = "23"
    private static void backtrack1(int index, String digits, List<String> res, String current, HashMap<Character, String> map){
        //base case
        if (index == digits.length()){
            res.add(current);
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            current = current + letters.charAt(i);
            backtrack1(index+1, digits, res, current, map);
            current = current.substring(0, current.length() - 1);
        }
    }

    public static List<String> letterCombinations2(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        backtrack2(0, digits, res, "", map);
        return res;
    }

    //digits = "23"
    private static void backtrack2(int index, String digits, List<String> res, String current, HashMap<Character, String> map){
        //base case
        if (index == digits.length()){
            res.add(current);
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
//            "" + "a"
//            current = current + letters.charAt(i);
            backtrack2(index+1, digits, res, current + letters.charAt(i), map);
//            ""
//            current = current.substring(0, current.length() - 1);
        }
    }

    public static List<String> letterCombinations3(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        backtrack3(0, digits, res, new StringBuilder(""), map);
        return res;
    }
    //K^N
    //digits = "23"
    private static void backtrack3(int index, String digits, List<String> res, StringBuilder current, HashMap<Character, String> map){
        //base case
        if (index == digits.length()){
            res.add(current.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = map.get(digit);
        for (int i = 0; i < letters.length(); i++) {
//            "" + "a"
//            current = current + letters.charAt(i);
            current.append(letters.charAt(i));
            backtrack3(index+1, digits, res, current, map);
            current.deleteCharAt(current.length()-1);
//            ""
//            current = current.substring(0, current.length() - 1);
        }
    }
}
