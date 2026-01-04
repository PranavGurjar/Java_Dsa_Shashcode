public class Lecture_53 {
    public static void main(String[] args) {
//        boolean res = checkPalindrome("NAMAN");

        boolean res = checkPalindrome("NaMAn");
        System.out.println(res);

        printPalindrome("NAMAN");
    }

    public static void printPalindrome(String input){
        int n = input.length();
//        String str = new String(input);
        String str = input;
        String rev = "";

        for (int i = 0; i < n; i++) {
            rev = str.charAt(i) + rev;
        }

//        String res = (str.equals(rev))?rev+ " is palindrome":rev + " is not palindrome";
//        System.out.println(res);
        if(str.equals(rev)){
            System.out.println(rev+ " is palindrome");
        }else {
            System.out.println(rev + " is not palindrome");
        }
    }

    public static boolean checkPalindrome(String input1){
        String input = input1.toLowerCase();
        int start = 0;
        int end = input.length()-1;

        while(start<end){
            if(input.charAt(start) != input.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

