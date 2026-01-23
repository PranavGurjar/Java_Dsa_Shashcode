package Greedy_Algorithm_For_Interviews;

import java.util.Arrays;

public class AssignMiceHoles {
    public static void main(String[] args) {
        int []mices = {4, -4, 2};
        int []holes = {4, 0, 5};
        int assignHole = assignHole(mices, holes);
        System.out.println("assignHole : "+assignHole);
    }

    //T -> 2(NLogN)
    public static int assignHole(int[] mices, int[] holes) {
        int n = mices.length;
        Arrays.sort(mices);
        Arrays.sort(holes);
        int maxTime = 0;
        for (int i = 0; i < n; i++) {
            maxTime = Math.max(maxTime, Math.abs(mices[i] - holes[i]));
        }
        return maxTime;
    }
}

