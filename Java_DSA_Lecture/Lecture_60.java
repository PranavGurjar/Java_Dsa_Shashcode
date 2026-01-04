import java.util.Stack;

public class Lecture_60 {
    public static void main(String[] args) {
//        Leetcode 921- Minimum add to make parentheses valid
        System.out.println(minAddToMakeValid1(")()(())((("));
        System.out.println(minAddToMakeValid2(")()(())((("));
    }

    public static int minAddToMakeValid2(String s) {
        int n = s.length();
        int ans = 0, open = 0, close = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '('){
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
        ans = open + close;
        return ans;
    }

    public static int minAddToMakeValid1(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '('){
                stack.push(ch);
            }
            else {
                if (stack.isEmpty() || stack.peek() == ')'){
                    stack.push(ch);
                }
                else {
                    stack.pop();
                }
            }
        }
        return stack.size();
    }
}
