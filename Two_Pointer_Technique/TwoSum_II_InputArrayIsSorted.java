package Two_Pointer_Technique;


public class TwoSum_II_InputArrayIsSorted {
    public static void main(String[] args) {
        int []numbers = {2, 3, 7, 11, 15};
        int[] twoSum = twoSum(numbers, 14);
        System.out.print("Answer : ");
        for (int i = 0; i < twoSum.length; i++) {
            System.out.print(twoSum[i]);
            if (i != twoSum.length-1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length-1;

        while (i<j){
            int sum = numbers[i] + numbers[j];
            if (sum == target){
                return new int[]{i + 1, j + 1};
            }
            if (sum < target){
                i++;
            }
            else {
                j--;
            }
        }
        return new int[2];
    }
}
