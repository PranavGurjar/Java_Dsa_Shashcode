package Top20InterviewJavaProblem;

import java.util.Stack;

public class BalancedParentheses_Stack {
    public static void main(String[] args) {
        System.out.println(isBalanced("({[]})"));
    }
    static boolean isBalanced(String s){
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                st.push(c);
            } else {
                if(st.isEmpty()) return false;
                char top = st.pop();
                if((c==')' && top!='(') ||
                        (c=='}' && top!='{') ||
                        (c==']' && top!='['))
                    return false;
            }
        }
        return st.isEmpty();
    }
}
