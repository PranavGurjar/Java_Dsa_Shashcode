import java.util.Stack;

public class Lecture_63 {
    public static void main(String[] args) {
        int []arr = {10, 2, -5, 4, -10, 20, 30, -40, 40};
        int[] ans = asteroidCollision(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
            if (i!=ans.length-1){
                System.out.print(", ");
            }
        }
    }


    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            if (stack.isEmpty() || asteroids[i] > 0){
                stack.push(asteroids[i]);
            }
            else {
                while (!stack.isEmpty()) {
                    int top = stack.peek();
                    if (top < 0) {
                        stack.push(asteroids[i]);
                        break;
                    }
                    int modVal = Math.abs(asteroids[i]);
                    if (modVal == top) {
                        stack.pop();
                        break;
                    } else if (modVal < top) {
                        break;
                    } else {
                        stack.pop();
                        if (stack.isEmpty()) {
                            stack.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }

        int len = stack.size();
        int ansArray[] = new int[len];

        for (int i = len-1; i >= 0; i--) {
            ansArray[i] = stack.pop();
        }
        return ansArray;
    }
}






//
//public static int[] asteroidCollision(int[] asteroids) {
//    Stack<Integer> stack = new Stack<>();
//
//    for (int i = 0; i < asteroids.length; i++) {
//        if (stack.isEmpty() || asteroids[i] > 0){
//            stack.push(asteroids[i]);
//        }
//        else {
//            while (!stack.isEmpty()){
//                int top = stack.peek();
//                if (top<0){
//                    stack.push(asteroids[i]);
//                    break;
//                }
//                int modVal = Math.abs(asteroids[i]);
//
//                if (modVal == top){
//                    stack.pop();
//                    break;
//                } else if (modVal < top) {
//                    break;
//                } else {
//                    stack.pop();
//                    if (stack.isEmpty()){
//                        stack.push(asteroids[i]);
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//    int len = stack.size();
//    int []ansArr = new int[len];
//    for (int i = len-1; i >= 0; i--) {
//        ansArr[i] = stack.pop();
//    }
//    return ansArr;
//}
//