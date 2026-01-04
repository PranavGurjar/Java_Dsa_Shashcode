import java.util.Stack;

public class Lecture_59 {
    public static void main(String[] args) {
//        Bracket Balancing - Count Minimum Bracket Removal (GFG Problem)
        int i = countMinReversals1("}{{}}{{{");
        System.out.println(i);
        int j = countMinReversals2("}{{}}{{{");
        System.out.println(j);
    }

    public static int countMinReversals2(String s) {
        if (s.length()%2 != 0){
            return -1;
        }

//        Stack<Character> stack = new Stack<>();
        int ans = 0, open = 0, close = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{'){
                open+=1;    //stack.push(ch);
            }
            else {
                //  insert incase of invalid pair }} or close comes before open
                //  if (stack.isEmpty() || stack.peek() == '}'){
                if(open<=0){
                    close++;    //stack.push(ch);
                }
                else {
                    //pop in case of valid pair {}
                    open--; //stack.pop();
                }
            }
        }


//        while(!stack.isEmpty()){
//            char top = stack.pop();
//
//            if (top == '{'){
//                open++;
//            }
//            else {
//                close++;
//            }
//        }
        ans = (int) (Math.ceil(open/2.0) + Math.ceil(close/2.0));
        return ans;
    }

    public static int countMinReversals1(String s) {
        if (s.length()%2 != 0){
            return -1;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '{'){
                stack.push(ch);
            }
            else {
                if (stack.isEmpty() || stack.peek() == '}'){
                    stack.push(ch);
                }
                else {
                    //pop in case of valid pair {}
                    stack.pop();
                }
            }
        }

        int ans = 0, open = 0, close = 0;

        while(!stack.isEmpty()){
            char top = stack.pop();

            if (top == '{'){
                open++;
            }
            else {
                close++;
            }
        }
        ans = (int) (Math.ceil(open/2.0) + Math.ceil(close/2.0));
        return ans;
    }
}




//    public static int countMinReversals2(String s) {
//        if (s.length()%2 != 0){
//            return -1;
//        }
//
//        int ans = 0, open = 0, close = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//
//            if (ch == '{'){
//                open += 1;
//            }
//            else {
//                if (open <= 0){
//                    close++;
//                }
//                else {
//                    open--;
//                }
//            }
//        }
//        ans = (int) (Math.ceil(open/2.0) + Math.ceil(close/2.0));
//        return ans;
//    }


