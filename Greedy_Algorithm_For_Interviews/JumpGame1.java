package Greedy_Algorithm_For_Interviews;


public class JumpGame1 {
    public static void main(String[] args) {
        int []nums = {2,3,1,1,4};
        boolean canJump = canJump(nums);
        System.out.println("canJump : "+canJump);
    }

    //O(N)
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int maxIndex = 0;
        int i = 0;
        while (i <= maxIndex){
            maxIndex = Math.max(maxIndex, i + nums[i]);
            if (maxIndex >= (n-1)){
                return true;
            }
            i++;
        }
        return false;
    }
}

