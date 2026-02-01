package Java;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        int romanToInt = romanToInt(s);
        System.out.println("\""+s+"\" romanToInt : "+romanToInt);
    }

    public static int romanToInt(String s) {
        int romanValues[] = new int[128];
        romanValues['I'] = 1;
        romanValues['V'] = 5;
        romanValues['X'] = 10;
        romanValues['L'] = 50;
        romanValues['C'] = 100;
        romanValues['D'] = 500;
        romanValues['M'] = 1000;
        int res = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (i+1 < n && romanValues[s.charAt(i)] < romanValues[s.charAt(i+1)]){
                // IVM -> (V - I) + M
                res += (romanValues[s.charAt(i+1)] - romanValues[s.charAt(i)]);
                i++;
            }
            else {
                res += romanValues[s.charAt(i)];
            }
        }
        return res;
    }
}