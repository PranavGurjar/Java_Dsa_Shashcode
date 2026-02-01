package String;

public class Rabin_Karp_Algorithm {
    public static void main(String[] args) {
        String txt = "sadbutsad";
        String pat = "sad";

        int strStr1 = strStr1(txt, pat);
        System.out.println("strStr1 : "+strStr1);

        int strStr2 = strStr2(txt, pat);
        System.out.println("strStr2 : "+strStr2);
    }

    public static int strStr1(String text, String pat) {
        int n = text.length();
        int m = pat.length();

        if (m > n) return -1;

        int base = 256;
        int mod = 101;
        int h = 1;
        for (int i = 0; i < m-1; i++) {
            h = (h * base)%mod;
        }
        //initial window hash
        int wh = 0;
        int ph = 0;
        for (int i = 0; i < m; i++) {
            wh = (base * wh + text.charAt(i))%mod;
            ph = (base * ph + pat.charAt(i))%mod;
        }
        if (wh == ph){
            int j = 0;
            while (j < m){
                if (text.charAt(j) != pat.charAt(j)){
                    break;
                }
                j++;
            }
            if (j == m){
                return 0;
            }
        }
        //solve for next window
        for (int i = 1; i <= n-m; i++) {
            //rolling hash
            wh = (wh - text.charAt(i-1) * h)%mod;
            wh = (wh * 256 + text.charAt(i+m-1))%mod;
            if (wh < 0){
                wh += mod;
            }
            //compare
            if (wh == ph){
                int j = 0;
                while (j < m){
                    if (text.charAt(i+j) != pat.charAt(j)){
                        break;
                    }
                    j++;
                }
                if (j == m){
                    return i;
                }
            }
        }
        return -1;
    }

    public static int strStr2(String text, String pat) {
        int n = text.length();
        int m = pat.length();

        if (m > n) return -1;

        int base = 256;
        int mod = 101;
        int h = 1;
        for (int i = 0; i < m-1; i++) {
            h = (h * base)%mod;
        }
        //initial window hash
        int wh = 0;
        int ph = 0;
        for (int i = 0; i < m; i++) {
            wh = (base * wh + text.charAt(i))%mod;
            ph = (base * ph + pat.charAt(i))%mod;
        }
        //solve for next window
        for (int i = 0; i <= n-m; i++) {
            //compare
            if (wh == ph){
                int j = 0;
                while (j < m){
                    if (text.charAt(i+j) != pat.charAt(j)){
                        break;
                    }
                    j++;
                }
                if (j == m){
                    return i;
                }
            }
            //rolling hash
            if (i<n-m){
                wh = (wh - text.charAt(i) * h)%mod;
                wh = (wh * 256 + text.charAt(i+m))%mod;
                if (wh < 0){
                    wh += mod;
                }
            }
        }
        return -1;
    }
}
