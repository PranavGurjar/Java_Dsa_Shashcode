import java.util.ArrayList;
import java.util.Stack;

public class Lecture_66 {
    public static void main(String[] args) {
        int []arr = {3, 8, 5, 2, 25};
        ArrayList<Integer> list = nextSmallerEle(arr);
        System.out.println(list);
    }
    public static ArrayList<Integer> nextSmallerEle(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int []res = new int[n];

        for (int i = n-1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() >= arr[i]){
                stack.pop();
            }

            if (stack.isEmpty()){
                res[i] = -1;
            }
            else {
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
