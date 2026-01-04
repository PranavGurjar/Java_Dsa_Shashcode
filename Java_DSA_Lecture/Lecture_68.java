import java.util.Stack;

public class Lecture_68 {
    public static void main(String[] args) {
        int []arr = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRectangleAreaTest(arr));
    }

    public static int largestRectangleArea(int[] heights) {
        int []ns = findNextSmaller(heights);
        int []ps = findPreviousSmaller(heights);

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int w = ns[i] - ps[i] - 1;     //upperLimit - lowerLimit - 1
            max = Math.max(max, (h * w));
        }
        return max;
    }

    public static int[] findPreviousSmaller(int []arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int []res = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                res[i] = -1;
            }
            else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] findNextSmaller(int []arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int []res = new int[n];

        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                res[i] = n;
            }
            else {
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }



    public static int largestRectangleArea1(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            int element = (i==n)?0:heights[i];
            while (!stack.empty() && heights[stack.peek()] > element){
                int h = heights[stack.pop()];
                int ps = (stack.isEmpty())?-1:stack.peek();
                int w = i - ps - 1;
                max = Math.max(max, (h*w));
            }
            stack.push(i);
        }
        return (max == Integer.MIN_VALUE)?0:max;
    }

    public static int largestRectangleAreaTest(int[] heights) {
        int n = heights.length;
        System.out.println("n : "+n);   //6
        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;
        System.out.println("max : "+max); //-2147483648

        for (int i = 0; i <= n; i++) {

            System.out.println("i : "+i);
            int element = (i==n)?0:heights[i];
            System.out.println("element : "+element);
            while (!stack.empty() && heights[stack.peek()] > element){
                int h = heights[stack.pop()];
                System.out.println("h : "+h);
                int ps = (stack.isEmpty())?-1:stack.peek();
                System.out.println("ps : "+ps);
                int w = i - ps - 1;
                System.out.println("w : "+w);
                max = Math.max(max, (h*w));
                System.out.println("max : "+max);
            }
            stack.push(i);
            System.out.println("*****************************************************");
        }
        System.out.println("max : "+max+", Integer.MIN_VALUE : "+Integer.MIN_VALUE);
        return (max == Integer.MIN_VALUE)?0:max;
    }


    public static int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int []stack = new int[n+1];
        int index = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            int element = (i == n)?0:heights[i];
            while ((index != -1) && heights[stack[index]] > element){
                int h = heights[stack[index--]];
                int ps = (index == -1)?-1:stack[index];
                int w = i - ps - 1;
                max = Math.max(max, (h*w));
            }
            stack[++index] = i;
        }
        return (max == Integer.MIN_VALUE)?0:max;
    }
}







/*

class Solution {
    public int largestRectangleArea(int[] heights) {
        int []ns = findNextSmaller(heights);
        int []ps = findPreviousSmaller(heights);

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < heights.length; i++){
            int h = heights[i];
            int w = ns[i] - ps[i] - 1;
            max = Math.max(max, (h * w));
        }
        return max;
    }

    public static int[] findPreviousSmaller(int []arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int []res = new int[n];

        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = -1;
            }
            else{
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    public static int[] findNextSmaller(int []arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int []res = new int[n];

        for(int i = n-1; i >= 0; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = n;
            }
            else{
                res[i] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }
}

 */