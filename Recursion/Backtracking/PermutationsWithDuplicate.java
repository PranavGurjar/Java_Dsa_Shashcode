package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PermutationsWithDuplicate {
    public static void main(String[] args) {
        int []nums = {1, 1, 2};
        List<List<Integer>> permuteUnique = permuteUnique(nums);
        System.out.println(permuteUnique);
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);      //NLogN
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        boolean []seen = new boolean[nums.length];
        permutations(nums, seen, current, res);     //N * !N
        return res;
    }

    public static void permutations(int nums[], boolean []seen, List<Integer> current,List<List<Integer>> res){
        //base case
        if (current.size() == nums.length){
            res.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // if seen then skip
            if (seen[i]) continue;

            //avoid duplicate
            if (i>0 && nums[i] == nums[i-1] && !seen[i-1]) continue;
            seen[i] = true;
            current.add(nums[i]);
            permutations(nums, seen, current, res);
            current.remove(current.size()-1);
            seen[i] = false;
        }
    }
}
