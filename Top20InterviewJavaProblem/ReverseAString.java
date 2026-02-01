package Top20InterviewJavaProblem;

public class ReverseAString {
    public static void main(String[] args) {
        String str = "hello";
        reverse1(str);
        reverse2(str);
    }
    public static void reverse1(String str) {
        String rev = new StringBuilder(str).reverse().toString();
        System.out.println(rev);
    }

    public static void reverse2(String str) {
        String rev = "";
        for (int i = 0; i < str.length(); i++) {
            rev = str.charAt(i) + rev;
        }
        System.out.println(rev);
    }
}
