package Sliding_Window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> anagrams = findAnagrams(s, p);
        System.out.println("anagrams : "+anagrams);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int m = p.length();
        List<Integer> list = new ArrayList<>();
        if (m>n) return list;
        int sCount[] = new int[26];
        int pCount[] = new int[26];
        //init window
        for (int i = 0; i < m; i++) {
            int si = s.charAt(i) - 'a';
            int pi = p.charAt(i) - 'a';
            sCount[si]++;
            pCount[pi]++;
        }
        if (Arrays.equals(sCount, pCount)){
            list.add(0);
        }
        for (int i = 1; i <= n-m; i++) {
            int prev = s.charAt(i - 1) - 'a';
            int next = s.charAt(i + m - 1) - 'a';
            sCount[prev]--;
            sCount[next]++;
            if (Arrays.equals(sCount, pCount)){
                list.add(i);
            }
        }
        return list;
    }
}