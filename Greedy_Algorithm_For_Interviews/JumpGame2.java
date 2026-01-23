package Greedy_Algorithm_For_Interviews;



public class JumpGame2 {
    public static void main(String[] args) {
        int []nums = {2,3,1,1,4};
        int jump = jump(nums);
        System.out.println("jump : "+jump);
    }

    //O(N)
    public static int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int minJump = 0;
        int maxIndex = 0;

        for (int i = 0; i < n-1; i++) {
            maxIndex = Math.max(maxIndex, i+nums[i]);
            if (i == end){
                minJump++;
                end = maxIndex;
            }
            if (end >= n-1){
                break;
            }
        }
        return minJump;
    }
}