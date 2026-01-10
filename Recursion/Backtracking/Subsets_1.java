package Backtracking;

import java.util.ArrayList;
import java.util.List;


public class Subsets_1 {
    public static void main(String[] args) {
        int []nums = {1, 2, 3};
        List<List<Integer>> subsets = subsets(nums);
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsequences(0, nums, current, res);
        return res;
    }

    public static void subsequences(int index, int nums[], List<Integer> current, List<List<Integer>> res){
        //base case
        if (index == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        //include
        current.add(nums[index]);
        subsequences(index+1, nums, current, res);

        //remove
        current.remove(current.size()-1);
        subsequences(index+1, nums, current, res);
    }
}
