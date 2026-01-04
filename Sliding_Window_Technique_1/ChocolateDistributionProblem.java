package Sliding_Window_Technique_1;

import java.util.ArrayList;
import java.util.Collections;


public class ChocolateDistributionProblem {
    public static void main(String[] args) {
        int []arr = {3, 4, 1, 9, 56, 7, 9, 12};
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i : arr){
            arrList.add(i);
        }
        System.out.println("arrList : "+arrList);
        int minDiff = findMinDiff(arrList, 5);
        System.out.println("minDiff : "+minDiff);
    }

    public static int findMinDiff(ArrayList<Integer> arr, int m) {
        if (arr.isEmpty()) return 0;

        int n = arr.size();
        int res = Integer.MAX_VALUE;
        Collections.sort(arr);
        System.out.println("SortList : "+arr);
        for (int i = 0; i < n-m+1; i++) {
            int minElement = arr.get(i);
            int maxElement = arr.get(i+m-1);
            res = Math.min(res, maxElement-minElement);
        }
        return res;
    }
}
