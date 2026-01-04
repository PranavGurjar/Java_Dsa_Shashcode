import java.util.ArrayList;
import java.util.Stack;

public class Lecture_67 {
    public static void main(String[] args) {
        int []nums = {2, 4, 1, 7, 9, 20, 16};
        ArrayList<Integer> list = nextGreaterElements(nums);
        System.out.println(list);
        System.out.println("************************************");
    }

    public static ArrayList<Integer> nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int []res = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i%n]){
                stack.pop();
            }
            if(i<n){
                if(stack.isEmpty()){
                    res[i] = -1;
                }
                else {
                    res[i] = stack.peek();
                }
            }
            stack.push(nums[i%n]);
        }
        for (int i : res){
            ans.add(i);
        }
        return ans;
    }

//    public static int[] nextGreaterElements1(int[] nums) {
    public static ArrayList<Integer> nextGreaterElements1(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int []res = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i%n]){
                stack.pop();
            }
            if (i < n){
                if (stack.isEmpty()){
                    res[i] = -1;
                }
                else {
                    res[i] = stack.peek();
                }
            }
            stack.push(nums[i%n]);
        }
        for(int i : res){
            ans.add(i);
        }
        return ans;
    }




//    public int[] nextGreaterElements2(int[] nums) {
    public static ArrayList<Integer> nextGreaterElements2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int []res = new int[n];
        for(int i=2*n-1;i>=0;i--) {
            System.out.println("Index is "+ i);
            System.out.println("Index considered is "+ (i%n));
            System.out.println("Element is " + nums[i%n]);
            while(!stack.isEmpty() && stack.peek()<=nums[i%n]){
                System.out.println("Popped:" + stack.peek());
                stack.pop();
            }
            if(i<n){
                if(stack.isEmpty()){
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
                System.out.println("Stored Result is "+ res[i]);
            }
            System.out.println("Pushed: "+ nums[i%n]);
            stack.push (nums[i%n]);
        }
        for(int i : res){
            ans.add(i);
        }
        return ans;
//    return res;
    }
}
