package Top20InterviewJavaProblem.StringProblems;

public class PalindromeString {
    static boolean isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

}
