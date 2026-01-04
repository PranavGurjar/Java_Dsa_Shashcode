import java.util.Stack;

public class Lecture_61 {
    public static void main(String[] args) {
        System.out.println(minSwaps1("]]][[["));
        System.out.println(minSwaps2("]]][[["));
    }
    public static int minSwaps2(String s) {
        if (s.length()%2 != 0){
            return -1;
        }

        int open = 0, close = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '['){
                open++;
            }
            else {
                if (open <= 0){
                    close++;
                }
                else {
                    open--;
                }
            }
        }

        return ((close + 1)/2);
    }

    public static int minSwaps1(String s) {
        if (s.length()%2 != 0){
            return -1;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '['){
                stack.push(ch);
            }
            else {
                if (stack.isEmpty() || stack.peek() == ']'){
                    stack.push(ch);
                }
                else {
                    stack.pop();
                }
            }
        }
        int totalBracket = stack.size();
        int closeBrackets = totalBracket/2;
        return ((closeBrackets + 1)/2);
    }
}
