package Top20InterviewJavaProblem;

public class CheckPalindromeString {
    public static void main(String[] args) {
        String str = "madam";
        System.out.println(isPalindrome1(str));
        System.out.println(isPalindrome2(str));
    }

    public static boolean isPalindrome1(String s){
        int i = 0;
        int j = s.length()-1;

        while (i < j){
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome2(String s){
        String rev = "";
        for (int i = 0; i < s.length(); i++) {
            rev = s.charAt(i) + rev;
        }
        if (s.equals(rev)){
            return true;
        }
        return false;
    }
}
