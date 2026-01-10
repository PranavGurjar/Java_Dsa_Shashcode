package Backtracking;

import java.util.ArrayList;
import java.util.List;


public class Permutations {
    public static void main(String[] args) {
        int []nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        permutations(nums, current, res);
        return res;
    }

    public static void permutations(int nums[], List<Integer> current,List<List<Integer>> res){
        //base case
        if (current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) continue;
            current.add(nums[i]);
            permutations(nums, current, res);
            current.remove(current.size()-1);
        }
    }
}
