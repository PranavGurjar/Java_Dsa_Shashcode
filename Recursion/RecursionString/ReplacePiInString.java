package Recursion.RecursionString;

public class ReplacePiInString {
    public static void main(String[] args) {
        String str = "XPIPIX";
        String replacePI = replacePI(str, 0);
        System.out.println(str+" : "+replacePI);
    }

    public static String replacePI(String str, int index){
        int n = str.length();
        if (index == n) return "";
        if (index < n-1 && str.charAt(index) == 'P' && str.charAt(index+1) == 'I'){
            return ("3.14" + replacePI(str, index+2));
        }
        else {
            return (str.charAt(index) + replacePI(str, index+1));
        }
    }
}
