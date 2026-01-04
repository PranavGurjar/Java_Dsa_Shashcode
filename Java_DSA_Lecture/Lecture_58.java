import java.util.Stack;

//Valid Parentheses
public class Lecture_58 {
    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
    }

    public static boolean isValid(String s) {
        int n = s.length();
        if (n%2 != 0){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[' ){
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.peek();
                if (ch == ')' && top != '('){
                    return false;
                } else if (ch == '}' && top != '{') {
                    return false;
                } else if (ch == ']' && top != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return (stack.size() == 0);
    }
}























//import java.util.Stack;
//
//public class Lecture_58 {
//    public static void main(String[] args) {
//        System.out.println(isValid("({[]})"));
//    }
//    public static boolean isValid(String s) {
//        int n = s.length();
//        if (n%2 != 0){
//            return false;
//        }
//
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < n; i++) {
//            char ch = s.charAt(i);
//
//            if (ch == '(' || ch == '{' || ch == '['){
//                stack.push(ch);
//            }
//            else {
//                if (stack.isEmpty()){
//                    return false;
//                }
//
//                char top = stack.peek();
//                if (ch == ')' && top != '('){
//                    return false;
//                } else if (ch == '}' && top != '{'){
//                    return false;
//                } else if (ch == ']' && top != '['){
//                    return false;
//                } else {
//                    stack.pop();
//                }
//            }
//        }
//        return (stack.size() == 0);
//    }
//}



