package Top20InterviewJavaProblem;

import java.util.Arrays;

public class AnagramCheck {
    public static void main(String[] args) {
        System.out.println(isAnagram1("listen", "silent"));
        System.out.println(isAnagram2("listen", "silent"));
        System.out.println(isAnagram3("listen", "silent"));
    }
    static boolean isAnagram1(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }

    static boolean isAnagram2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }

    static boolean isAnagram3(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] freq = new int[256]; // ASCII

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i)]++;
            freq[s2.charAt(i)]--;
        }

        for (int count : freq) {
            if (count != 0) return false;
        }
        return true;
    }

}
