public class Lecture_56 {
    public static void main(String[] args) {
        reverseWords1("we are coders");
        reverseWords2("we are coders");
    }

    public static void reverseWords2(String s) {
        StringBuilder sb = new StringBuilder(s);
        int len = sb.length();
        int startPointer = 0;

        for (int endPointer = 0; endPointer <= len; endPointer++) {
            if(endPointer == len || sb.charAt(endPointer) == ' '){
                reverse2(sb, startPointer, endPointer-1);
                startPointer = endPointer + 1;
            }
        }
        System.out.println(sb.toString());
    }

    public static void reverse2(StringBuilder sb, int startPointer, int endPointer){
        while (startPointer < endPointer){
            char temp = sb.charAt(startPointer);
            sb.setCharAt(startPointer, sb.charAt(endPointer));
            sb.setCharAt(endPointer, temp);

            startPointer++;
            endPointer--;
        }
    }

    public static void reverseWords1(String s) {
        char arr[] = s.toCharArray();
        int len = arr.length;
        int startPointer = 0;

        for (int endPointer = 0; endPointer <= len; endPointer++) {
            if (endPointer == len || arr[endPointer] == ' '){
                reverse1(arr, startPointer, endPointer-1);
                startPointer = endPointer + 1;
            }
        }
        System.out.println(arr);
    }

    public static void reverse1(char arr[], int startPointer, int endPointer){
        while (startPointer < endPointer){
            char temp = arr[startPointer];
            arr[startPointer] = arr[endPointer];
            arr[endPointer] = temp;

            startPointer++;
            endPointer--;
        }
    }
}




















//class Solution {
//    public String reverseWords(String s) {
//        char arr[] = s.toCharArray();
//        int len = arr.length;
//        int startPointer = 0;
//
//        for (int endPointer = 0; endPointer <= len; endPointer++) {
//            if (endPointer == len || arr[endPointer] == ' '){
//                reverse(arr, startPointer, endPointer-1);
//                startPointer = endPointer + 1;
//            }
//        }
//        return new String(arr);
//    }
//
//    public static void reverse(char arr[], int startPointer, int endPointer){
//        while (startPointer < endPointer){
//            char temp = arr[startPointer];
//            arr[startPointer] = arr[endPointer];
//            arr[endPointer] = temp;
//
//            startPointer++;
//            endPointer--;
//        }
//    }
//}