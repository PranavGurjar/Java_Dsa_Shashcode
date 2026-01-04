package Recursion;

import java.util.ArrayList;

public class PrintAllOccurrence {
    public static void main(String[] args) {
        int []arr = {7, 4, 1, 4, 5, 8, 4, 2};
        int []res = new int[arr.length];
        int target = 4;

        int ans = printAllOccurrence (arr, 0, target, res, 0);
        System.out.print("Answer : ");
        for (int i = 0; i < ans; i++) {
            System.out.print(res[i]);
            if (i != ans-1) System.out.print(", ");
        }
        System.out.println();
    }

    public static int printAllOccurrence(int []arr, int index, int target, int []res, int count){
        if (index == arr.length) return count;      //base case
        if (target == arr[index]) {
            res[count++] = index;
        }
        return printAllOccurrence(arr, index+1, target, res, count);
    }
}
