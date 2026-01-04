package Sliding_Window_Technique_2;

import java.util.HashMap;
import java.util.HashSet;


public class LongestSubstringWithDistinctCharacters {
    public static void main(String[] args) {
        String str = "abcdcdea";
        int lengthOfLongestSubstring1 = lengthOfLongestSubstring1(str);
        System.out.println("lengthOfLongestSubstring1 : "+lengthOfLongestSubstring1);

        int lengthOfLongestSubstring2 = lengthOfLongestSubstring2(str);
        System.out.println("lengthOfLongestSubstring2 : "+lengthOfLongestSubstring2);
    }

    public static int lengthOfLongestSubstring1(String s) {
        int windowStart = 0;
        int windowEnd = 0;
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int maxLen = Integer.MIN_VALUE;

        while (windowEnd < n){
            char ch = s.charAt(windowEnd);
            if (set.contains(ch)){
                //shrinking
                while (windowStart < windowEnd && set.contains(ch)){
                    set.remove(s.charAt(windowStart));
                    windowStart++;
                }
            }
            set.add(ch);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return (maxLen == Integer.MIN_VALUE)?0:maxLen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int windowStart = 0;
        int windowEnd = 0;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;

        while (windowEnd < n){
            char ch = s.charAt(windowEnd);
            if (map.containsKey(ch) && map.get(ch) >= windowStart){
                //shrinking
                windowStart = map.get(ch) + 1;
            }
            map.put(ch, windowEnd);
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
            windowEnd++;
        }
        return (maxLen == Integer.MIN_VALUE)?0:maxLen;
    }
}
