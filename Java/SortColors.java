package Java;


//Sort Colors | partition sorting
public class SortColors {
    public static void main(String[] args) {
        int []arr = {2, 0, 2, 1, 1, 0};
        int[] sortColors = sortColors(arr);
        System.out.print("SortColor : ");
        for (int i = 0; i < sortColors.length; i++) {
            System.out.print(sortColors[i]);
            if (i != sortColors.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static void swap(int []nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int[] sortColors(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int index = 0;
        while (index <= end){
            if (nums[index] == 0){
                swap(nums, index, start);
                index++;
                start++;
            }
            else if (nums[index] == 2){
                swap(nums, index, end);
                end--;
            }
            else {
                index++;
            }
        }
        return nums;
    }
}
