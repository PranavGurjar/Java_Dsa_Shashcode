package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class CombinationSum2 {
    public static void main(String[] args) {
        int []candidates = {2, 5, 1, 2};
        List<List<Integer>> combinationSum2 = combinationSum2(candidates, 5);
        System.out.println("combinationSum2 : "+combinationSum2);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> current = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(0, current, res, candidates, target);
        return res;
    }

    public static void backtrack(int index, List<Integer> current, List<List<Integer>> res, int []candidates, int target){
        //base case
        if (target == 0){
            res.add(new ArrayList<>(current));
            return;
        }

        int n = candidates.length;

//        if (index == n){
//            return;
//        }

        for (int i = index; i < n; i++) {
            if (i == index || candidates[i] != candidates[i-1] && candidates[i] <= target){
                current.add(candidates[i]);
                backtrack(i+1, current, res, candidates, target - candidates[i]);
                current.remove(current.size()-1);
            }
        }
    }
}
