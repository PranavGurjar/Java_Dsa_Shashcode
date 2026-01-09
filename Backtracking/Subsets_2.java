package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

}

public class Subsets_2 {
    public static void main(String[] args) {
        int []nums = {1, 2, 2};
        List<List<Integer>> subsets = subsetsWithDup(nums);
        System.out.println(subsets);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);      //NLogN
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        subsequences(0, nums, current, res);    //N * 2^N
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
        //pick
        subsequences(index+1, nums, current, res);

        //remove
        current.remove(current.size()-1);
        //no pick
        //avoid all duplicates
        while ((index+1) < nums.length && nums[index] == nums[index+1]) {
            index++;
        }
        subsequences(index+1, nums, current, res);
    }
}
