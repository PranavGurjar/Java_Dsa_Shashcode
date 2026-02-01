package String;

import java.util.HashMap;
import java.util.HashSet;


public class LongestPalindrome {
    public static void main(String[] args) {
        String str = "abccccddeee";

        int longestPalindrome1 = longestPalindrome1(str);
        System.out.println("longestPalindrome1 : "+longestPalindrome1);

        int longestPalindrome2 = longestPalindrome2(str);
        System.out.println("longestPalindrome2 : "+longestPalindrome2);

        int longestPalindrome3 = longestPalindrome3(str);
        System.out.println("longestPalindrome3 : "+longestPalindrome3);
    }

    public static int longestPalindrome1(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int res = 0;
        int oddCount = 0;
        for (char ch : s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
            int curFreq = freqMap.get(ch);
            if (curFreq % 2 == 0){
                res += 2;
                oddCount--;
            }
            else {
                oddCount++;
            }
        }
        if (oddCount > 0){
            res += 1;
        }
        return res;
    }

    public static int longestPalindrome2(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                res += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }
        if (set.size() > 0){
            res += 1;
        }
        return res;
    }

    public static int longestPalindrome3(String s) {
        int set[] = new int[128];
        int res = 0;
        int oddCount = 0;
        for (char ch : s.toCharArray()) {
            if (set[ch] != 0) {
                res += 2;
                set[ch] = 0;
                oddCount--;
            } else {
                set[ch] = 1;
                oddCount++;
            }
        }
        if (oddCount > 0){
            res += 1;
        }
        return res;
    }
}