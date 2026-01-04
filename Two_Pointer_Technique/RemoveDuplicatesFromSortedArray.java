package Two_Pointer_Technique;


public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int []nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int removeDuplicates = removeDuplicates(nums);
        System.out.println("removeDuplicates : "+removeDuplicates);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int n = nums.length;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[k]){
                k++;
                nums[k] = nums[i];
            }
        }
        return k+1;
    }
}
