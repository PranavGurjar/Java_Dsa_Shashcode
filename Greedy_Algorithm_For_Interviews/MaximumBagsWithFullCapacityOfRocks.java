package Greedy_Algorithm_For_Interviews;

import java.util.Arrays;

public class MaximumBagsWithFullCapacityOfRocks {
    public static void main(String[] args) {
        int []capacity = {2,3,4,5};
        int []rocks = {1,2,4,4};
        int additionalRocks = 2;
        int maximumBags = maximumBags(capacity, rocks, additionalRocks);
        System.out.println("maximumBags : "+maximumBags);
    }

    //NLogN
    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int diff[] = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (diff[i] <= additionalRocks){
                additionalRocks -= diff[i];
                diff[i] = 0;
            }
            if (diff[i] == 0){
                count++;
            }
        }
        return count;
    }
}