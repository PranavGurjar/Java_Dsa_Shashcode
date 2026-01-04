package Two_Pointer_Technique;


public class ContainerWithMostWater {
    public static void main(String[] args) {
        int []height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println("maxArea : "+maxArea);
    }

    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int ans = 0;
        while (i<j){
            ans = Math.max(ans, (j-i) * Math.min(height[i], height[j]));
            if (height[i] <= height[j]){
                i++;
            }
            else {
                j--;
            }
        }
        return ans;
    }
}
