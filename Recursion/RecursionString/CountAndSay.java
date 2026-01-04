package Recursion.RecursionString;

public class CountAndSay {
    public static void main(String[] args) {
        int n = 4;
        String countAndSay = countAndSay(n);
        System.out.println(n+" : "+countAndSay);
    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";     //base case
        String prev = countAndSay(n-1);
        StringBuilder res = new StringBuilder("");
        int count = 0;
        int len = prev.length();
        for (int i = 0; i < len; i++) {
            count++;
            if (i == len-1 || prev.charAt(i) != prev.charAt(i+1)){
                res.append(count).append(prev.charAt(i));
                count = 0;
            }
        }
        return res.toString();
    }
}
