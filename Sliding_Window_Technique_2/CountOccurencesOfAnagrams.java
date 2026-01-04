package Sliding_Window_Technique_2;

import java.util.Arrays;


public class CountOccurencesOfAnagrams {
    public static void main(String[] args) {
        String pat = "for";
        String txt = "forxxorfxdofr";
        int search = search(pat, txt);
        System.out.println("CountOccurencesOfAnagrams : "+search);
    }
    public static int search(String pat, String txt) {
        int n = txt.length();
        int k = pat.length();

        //calc pat freq
        int patFreq[] = new int[26];
        for (int i = 0; i < k; i++) {
            int index = pat.charAt(i) - 97;
            patFreq[index]++;
        }
        //init window
        int txtFreq[] = new int[26];
        for (int i = 0; i < k; i++) {
            int index = txt.charAt(i) - 97;
            txtFreq[index]++;
        }

        int count = 0;

        if (Arrays.equals(txtFreq, patFreq)){
            count++;
        }

        //calc for other windows
        for (int i = 1; i < n-k+1;i++) {
            int removeCharIndex = txt.charAt(i-1) - 97;
            int addedCharIndex = txt.charAt(i+k-1) - 97;
            txtFreq[addedCharIndex]++;
            txtFreq[removeCharIndex]--;
            if (Arrays.equals(txtFreq, patFreq)){
                count++;
            }
        }
        return count;
    }
}
