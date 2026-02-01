package Java;

public class Check_K_Anagrams {
    public static void main(String[] args) {
        String s1 = "fodr";
        String s2 = "gork";
        int k = 2;

        boolean areKAnagrams1 = areKAnagrams1(s1, s2, k);
        System.out.println("areKAnagrams1 : "+areKAnagrams1);

        boolean areKAnagrams2 = areKAnagrams2(s1, s2, k);
        System.out.println("areKAnagrams2 : "+areKAnagrams2);
    }

    static boolean areKAnagrams2(String s1, String s2, int k) {
        int n = s1.length();
        int m = s2.length();
        if (n != m) return false;

        int freq[] = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) count += freq[i];
        }
        return (count <= k);
    }

    static boolean areKAnagrams1(String s1, String s2, int k) {
        int n = s1.length();
        int m = s2.length();
        if (n != m) return false;

        int freq[] = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            int index = s2.charAt(i) - 'a';
            if (freq[index] > 0) {
                freq[index]--;
            }
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += freq[i];
        }
        return (count <= k);
    }
}

