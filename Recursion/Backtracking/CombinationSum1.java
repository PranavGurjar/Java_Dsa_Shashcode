package Backtracking;

import java.util.ArrayList;
import java.util.List;


public class CombinationSum1 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> combinationSum = combinationSum(candidates, target);
        System.out.println("combinationSum : "+combinationSum);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtrack(0, current, res, candidates, target);
        return res;
    }

    public static void backtrack(int index, List<Integer> current, List<List<Integer>> res, int[] candidates, int target){
        //base case
        if (target == 0){
            res.add(new ArrayList<>(current));
            return;
        }

        if (index == candidates.length){
            return;
        }

        //pick
        if (candidates[index] <= target){
            current.add(candidates[index]);
            backtrack(index, current, res, candidates, target-candidates[index]);
            current.remove(current.size()-1);
        }
        //no pick
        backtrack(index+1, current, res, candidates, target);
    }
}
