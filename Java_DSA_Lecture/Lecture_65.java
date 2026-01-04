import java.util.ArrayList;
import java.util.Stack;

public class Lecture_65 {
    public static void main(String[] args) {
        int []arr = {2, 1, 7, 11, 12, 3, 6, 9};
        ArrayList<Integer> list = nextLargerElement(arr);
        System.out.println(list);
    }


    public static ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int []res = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                res[i] = -1;
            }else {
                res[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        for (int i : res){
            ans.add(i);
        }
        return ans;
    }
}






//class Solution {
//    public static ArrayList<Integer> nextLargerElement(int[] arr) {
//        // code here
//        Stack<Integer> stack = new Stack<>();
//        int n = arr.length;
//        int []res = new int[n];
//        ArrayList<Integer> ans = new ArrayList<>();
//        for (int i = n-1; i >= 0; i--) {
//            while(!stack.isEmpty() && stack.peek() <= arr[i]){
//                stack.pop();
//            }
//            if (stack.isEmpty()){
//                res[i] = -1;
//            }else {
//                res[i] = stack.peek();
//            }
//            stack.push(arr[i]);
//        }
//
//        for (int i : res){
//            ans.add(i);
//        }
//        return ans;
//    }
//}