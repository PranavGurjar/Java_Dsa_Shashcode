package Sliding_Window_Technique_2;

import java.util.HashMap;


public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        String minWindow = minWindow(S, T);
        System.out.println("minWindow : "+minWindow);
    }

    //T -> M
    //S -> N
    //TC -> O(M + 2N) ~ O(N + M)
    //SC -> O(M)
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        //populate the map with t string
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }
        int uniqueCharCount = freqMap.size();
        int startIndex = -1;
        int windowStart = 0;
        int windowEnd = 0;
        int minLen = Integer.MAX_VALUE;
        int n = s.length();

        while (windowEnd < n){
            //Expansion Phase
            char ch = s.charAt(windowEnd);
            if (freqMap.containsKey(ch)){
                freqMap.put(ch, freqMap.getOrDefault(ch, 0)-1);
                if (freqMap.get(ch) == 0){
                    uniqueCharCount--;
                }
            }

            //Shrinking Phase
            while (uniqueCharCount == 0){
                //find len
                int len = windowEnd - windowStart + 1;
                if(len < minLen){
                    minLen = len;
                    startIndex = windowStart;
                }

                ch = s.charAt(windowStart);
                if (freqMap.containsKey(ch)){
                    freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
                    if (freqMap.get(ch) > 0){
                        uniqueCharCount++;
                    }
                }
                windowStart++;
            }
            windowEnd++;
        }

        if (startIndex == -1){
            return "";
        }
        return s.substring(startIndex, startIndex + minLen);
    }
}
