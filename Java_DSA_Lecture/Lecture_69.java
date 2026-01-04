import java.util.Stack;

public class Lecture_69 {
    public static void main(String[] args) {
        char [][]matrix =   {
                                {'0','1','1','0','0','0'},
                                {'1','0','1','0','1','0'},
                                {'1','1','0','1','0','1'},
                                {'0','1','1','1','0','1'},
                                {'1','1','1','0','1','0'}
                            };


        System.out.println(maximalRectanglePRM(matrix));
    }

    public static int maximalRectanglePRM(char[][] matrix){
        int []height = new int[matrix[0].length];
        int largest = 0;

        if(matrix.length == 0){
            return 0;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int val = matrix[i][j] - '0';

                if(val == 0){
                    height[j] = val;
                }
                else {
                    height[j] += val;
                }
            }

            int maxArea = largestRectangleAreaPRM(height);

            if(largest < maxArea){
                largest = maxArea;
            }
        }
        return largest;
    }

    public static int largestRectangleAreaPRM(int []height){
        int n = height.length;
        int []stack = new int[n];
        int index = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            int element = (i == n)?0:height[i];
            while ((index != -1) && height[stack[index]] > element){
                int h = height[stack[index--]];
                int ps = (index == -1)?-1:stack[index];
                int w = i - ps - 1;
                max = Math.max(max, (h*w));
            }
            stack[++index] = i;
        }
        return (max == Integer.MIN_VALUE)?0:max;
    }





    public static int maximalRectangle(char[][] matrix) {
        //if there are no row then return
        if(matrix.length == 0){
            return 0;
        }

        System.out.println("matrix.length : "+matrix.length);
        System.out.println("matrix[0].length : "+matrix[0].length);

        //find the numbers of columns in a row
        int heights[] = new int[matrix[0].length];
        int largest = 0;

        //O(N^2)
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int val = matrix[i][j] - '0'; //char to int
//                System.out.println("val : "+val);
//                System.out.println("i : "+i+", j : "+j);
//                System.out.println("matrix.length : "+matrix.length);
//                System.out.println("matrix[i].length : "+matrix[i].length);
                if (val == 0){
                    heights[j] = 0;
                }
                else {
                    heights[j] += val;
                    System.out.println("heights[j] : "+heights[j]);
                }
            }

            int maxArea = largestRectangleArea(heights);
            System.out.println("maxArea : "+maxArea);
            if (largest<maxArea){
                System.out.println("largest : "+largest);
                largest = maxArea;
                System.out.println("largest : "+largest);
            }
        }
        return largest;
    }

    //O(3N)
    public static int largestRectangleArea(int []arr){
        int n = arr.length;
        int []stack = new int[n+1];
        int index = -1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i<=n; i++){
            int element = (i==n)?0:arr[i];
            while((index != -1) && arr[stack[index]] > element){
                int h = arr[stack[index--]];
                int ps = (index == -1)?-1:stack[index];
                int w = i - ps - 1;
                max = Math.max(max, (h*w));
            }
            stack[++index] = i;
        }
        return (max == Integer.MIN_VALUE)?0:max;
    }
}
